package streams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static int sum_sequential_Stream(){
        return IntStream.rangeClosed(1,100000).sum();
    }

    public static int sum_parallel_Stream(){
        return IntStream.rangeClosed(1,100000).parallel().sum();
    }

    public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfTimes;i++){
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Sequential Stream Result: "+checkPerformanceResult(ParallelStreamExample::sum_sequential_Stream, 20));
        System.out.println("Parallel Stream Result: "+checkPerformanceResult(ParallelStreamExample::sum_parallel_Stream, 20));
        System.out.println("sum_sequential_Stream: "+sum_sequential_Stream());
        System.out.println("sum_parallel_Stream: "+sum_parallel_Stream());

    }
}
