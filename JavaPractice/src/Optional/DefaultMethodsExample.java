package Optional;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class DefaultMethodsExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Adam","Jenny","Alex","Dan","Mike","Eric");
//        Collections.sort(stringList);
//        System.out.println("Sorted list using Collections.Sort():"+stringList);

        stringList.sort(Comparator.naturalOrder());
        System.out.println("Sorted list using List.Sort():"+stringList);
        stringList.sort(Comparator.reverseOrder());
        System.out.println("Sorted list using List.reverse.Sort():"+stringList);

    }
}
