import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> sc.nextInt());
        // 1. 최댓값 뽑는다
        final int max = IntStream.of(arr).max().orElse(0);
        // 2. stream으로 average 구한다.
        double average = IntStream.of(arr)
                .mapToDouble(Double::new)
                .map(i -> i / max * 100).average().orElse(0);

        System.out.println(average);
    }
}
