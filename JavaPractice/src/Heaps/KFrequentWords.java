package Heaps;
import java.util.*;

public class KFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        int n = words.length;
        for(String word:words){
            wordCount.put(word, wordCount.getOrDefault(word,0)+1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b)-> (a.second != b.second) ? b.second - a.second : a.first.compareTo(b.first));

        for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        List<String> res = new ArrayList<>();
        while(k > 0){
            res.add(maxHeap.peek().first);
            maxHeap.poll();
            k--;
        }
        return res;

    }
    static class Pair{
        String first;
        int second;
        Pair(String f, int s){
            first = f;
            second = s;
        }
    }
}
