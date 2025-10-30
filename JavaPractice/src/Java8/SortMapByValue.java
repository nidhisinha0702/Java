package Java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Apple", 3);
        unsortedMap.put("Banana", 1);
        unsortedMap.put("Kiwi", 4);
        unsortedMap.put("Cherry", 2);

        Map<String, Integer> sortedMapAsc = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function for duplicate keys (not expected here if keys are unique)
                        LinkedHashMap::new // Preserve insertion order
                ));

        System.out.println("Sorted Map (Ascending by Value): " + sortedMapAsc);
    }
}