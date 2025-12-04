package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
public class FirstUniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "level";
		System.out.println(nonRepeatingChar(str));
	}
	//O(n)
	public static int firstUniqChar(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        //ietrate over the string
        for(int i=0;i<s.length();i++){
            //check if the char is unique
            if(!mpp.containsKey(s.charAt(i))){
                q.offer(i);
            }
            //increase the character freq in map
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0)+1);

            //pop repeating values
            while(q.size() > 0 && mpp.get(s.charAt(q.peek())) > 1)
                q.poll();

        }
        return q.isEmpty() ? -1:q.peek();
    }
	//O(n)
	public static int firstUniqCharOpti(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        //ietrate over the string
        for(int i=0;i<s.length();i++){
           //freq in mpp
           mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(mpp.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
       
    }
	
	public static char nonRepeatingChar(String s) {
		
		return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(null);
	}

}
