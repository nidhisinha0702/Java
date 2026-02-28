package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println("reorganized string so that two adjacent characters are not same :"+reorganizeString(s));
    }
    public static String reorganizeString(String s) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b)->b.second - a.second);
        for(Map.Entry<Character,Integer> entry:charCount.entrySet()){
            maxHeap.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        char res[] = new char[n];
        int seat = 0;
        while(!maxHeap.isEmpty()){
            Pair p = maxHeap.poll();
            if(seat == 0 || res[seat - 1] != p.first){
                res[seat] = p.first;
                seat++;
                p.second--;
                if(p.second>0){
                    maxHeap.offer(p);
                }
            }else{
                if(maxHeap.isEmpty()){
                    return "";
                }
                Pair p2 = maxHeap.poll();
                res[seat]=p2.first;
                p2.second--;
                seat++;
                if(p2.second>0){
                    maxHeap.offer(p2);
                }
                maxHeap.offer(p);
            }
        }return new String(res);
    }
    static class Pair{
        char first;
        int second;
        Pair(char c,int i){
            first = c;
            second = i;
        }
    }
}
