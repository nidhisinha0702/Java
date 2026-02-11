package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int result[][] = merge(intervals);
		Arrays.stream(result).map(Arrays::toString).forEach(System.out::println);

	}
	 public static int[][] merge(int[][] intervals) {
	        int n = intervals.length;
	        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
	        int start1 = intervals[0][0];
	        int end1 = intervals[0][1];
	        List<List<Integer>> result = new ArrayList<>();

	        for(int i=1;i<n;i++){
	            int start2 = intervals[i][0];
	            int end2 = intervals[i][1];
	            if(end1 >= start2){
	                start1 = start1;
	                end1 = Math.max(end1,end2);
	                continue;
	            }else{
	                List<Integer> inter = new ArrayList<>();
	                inter.add(start1);
	                inter.add(end1);
	                result.add(inter);
	                start1 = start2;
	                end1 = end2;
	            }
	        }List<Integer> inter = new ArrayList<>();
	        inter.add(start1);
	        inter.add(end1);
	        result.add(inter);
	        return result.stream().map(innerList->innerList.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
	    }

}
