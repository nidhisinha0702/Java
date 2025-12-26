package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(1,1,1,2,2,3);
		int k = 2;
		List<Integer> topK = topKFreqStreams(nums, k);
		System.out.println(topK);

	}
	
	public static List<Integer> topKFrequent(List<Integer> nums, int k){
		
		//count frequencies
		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
		}
		
		//use min-heap to keep top k elements
		PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
			(a,b) -> a.getValue() - b.getValue());
		
		for(Map.Entry<Integer, Integer> entry:freqMap.entrySet()) {
			minHeap.offer(entry);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		//extract results
		List<Integer> result = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			result.add(minHeap.poll().getKey());
		}
		
		Collections.reverse(result);
		return result;
		
	}
	
	public static List<Integer> topKFreqStreams(List<Integer> nums, int k){
		
		return nums.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())).entrySet().stream()
				.sorted((a,b)->Long.compare(b.getValue(), a.getValue())).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
	}

}
