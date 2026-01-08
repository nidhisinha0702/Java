package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = {{1,3},{6,9}}, newInterval[] = {2,5};
		int ans[][] = insert(intervals, newInterval);
		Arrays.stream(ans).map(Arrays::toString).forEach(System.out::println);

	}
	public static int[][] insert(int[][] intervals, int[] newInterval) {
        //create a new list and insert everything
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        //sort on the basis of start
        Collections.sort(intervalList, (a,b) ->Integer.compare(a[0],b[0]));
        //call merge interval
        return merge(intervalList);
    }
    public static int[][] merge(List<int[]> interval){
        int n = interval.size();
        int start1 = interval.get(0)[0];
        int end1 = interval.get(0)[1];
        List<int[]> result = new ArrayList<>();

        for(int i=1;i<n;i++){
            int start2 = interval.get(i)[0];
            int end2 = interval.get(i)[1];
            if(end1 >= start2){
                end1 = Math.max(end1,end2);
                continue;
            }else{
                result.add(new int[]{start1,end1});
                start1 = start2;
                end1 = end2;
            }
        }result.add(new int[]{start1,end1});
                //convert list to array
            return result.toArray(new int[result.size()][]);
    }
}
