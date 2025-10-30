package Java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValueDescending {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Apple", 3);
        unsortedMap.put("Banana", 1);
        unsortedMap.put("Kiwi", 4);
        unsortedMap.put("Cherry", 2);

        Map<String, Integer> sortedMapDesc = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println("Sorted Map (Descending by Value): " + sortedMapDesc);
    }
}