package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,-1,0,3,10};
		int ans[] = sortedSquares(nums);
		System.out.println(Arrays.toString(ans));

	}
	
	public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        //Add pos and neg elements to the lists
        for(int x:nums){
            if(x > 0){
                pos.add(x);
            }else{
                neg.add(x);
            }
        }

        //case 1 No negative numbers
        if(neg.size() == 0){
            for(int i=0;i<pos.size();i++){
                pos.set(i, pos.get(i)*pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }

        //case 2 No Positive numbers
        else if(pos.size() == 0){
             for(int i=0;i<neg.size();i++){
                neg.set(i, neg.get(i)*neg.get(i));
            }
            //reverse as negative numbers are sorted in descending order after squared
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }
        //case 3 Both negative and positive exist
        
            int i=0, j=0, id=0;
            int n1 = neg.size();
            int n2 = pos.size();
            int[] res = new int[n1+n2];

            //square negative and reverse them
            for(i = 0;i<n1;i++)
                neg.set(i, neg.get(i)*neg.get(i));
            Collections.reverse(neg);

            //square positive 
            for(i=0;i<n2;i++)
                pos.set(i, pos.get(i)*pos.get(i));

            i=0;
            while(i<n1 && j<n2){
                if(neg.get(i)<=pos.get(j)){
                    res[id++] = neg.get(i++);
                }else{
                    res[id++] = pos.get(j++);
                }
            }

            while(i<n1){
                res[id++] = neg.get(i++);
            }
            while(j<n2){
                res[id++] = pos.get(j++);
            }
            return res;
        
    }

}
