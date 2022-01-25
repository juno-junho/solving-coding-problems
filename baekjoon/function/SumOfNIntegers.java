import java.util.stream.IntStream;

public class SumOfNIntegers {
    long sum(int[] a) {
//        long sum = IntStream.of(a).mapToLong(Long::new).sum();
        long sum = 0;
        for (int num : a) {
            sum += num;
        };
        return sum;
    }
}
