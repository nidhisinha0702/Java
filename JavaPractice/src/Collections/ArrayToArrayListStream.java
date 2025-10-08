package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayToArrayListStream {
    public static void main(String[] args) {
        // Original array
        String[] stringArray = {"Apple", "Banana", "Cherry", "Date"};

        // Convert array to ArrayList using Stream API
        ArrayList<String> arrayList = Arrays.stream(stringArray)
                                          .collect(Collectors.toCollection(ArrayList::new));

        // Print the resulting ArrayList
        System.out.println("ArrayList: " + arrayList);

        // Example with an Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        ArrayList<Integer> integerList = Arrays.stream(intArray)
                                             .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Integer ArrayList: " + integerList);
    }
}