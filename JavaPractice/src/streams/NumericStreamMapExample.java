package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class NumericStreamMapExample {
    public static void main(String[] args) {
        System.out.println("mapToObj : "+mapToObj());
        System.out.println("mapToLong : "+mapToLong());
        System.out.println("mapToDouble : "+mapToDouble());
    }

    public static List<Integer> mapToObj(){
        return IntStream.rangeClosed(1,5)
                .mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public static long mapToLong(){
        return IntStream.rangeClosed(1,5)//intstream
                //i is passed from the intstream
                .mapToLong(i->i).sum();//convert intstream to longstream
    }

    public static double mapToDouble(){
        return IntStream.rangeClosed(1,5)//intstream
                //i is passed from the intstream
                .mapToDouble(i->i).sum();//convert intstream to doublestream
    }
}
