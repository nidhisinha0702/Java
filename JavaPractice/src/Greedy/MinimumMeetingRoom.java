package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{0,30},{1,15},{15,25}};
		System.out.println("Minimum meeting room required for n meetings is : "+minMeetingRoom(intervals));

	}
	
	public static int minMeetingRoom(int[][] meetings) {
		
		//sort the meeting based on start time
		Arrays.sort(meetings, (x,y)->Integer.compare(x[0],y[0]));
		
		//PriorityQueue for choosing a ds that is keeping min end time on top
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int[] i:meetings) {
			if(pq.isEmpty()) {
				pq.add(i[1]);
				continue;
			}
			
			//same room
			if(pq.peek() <= i[0]) {
				pq.remove();
			}
			
			pq.add(i[1]);
		}return pq.size();
	}

}
