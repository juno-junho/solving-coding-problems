import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1. 공식
        System.out.println((n*(n+1)/2));

        // 2. sum += 해서 for문
        int sum1 = 0;
        for (int i = 1; i < n+1; i++) {
            sum1 += i;
        }
        System.out.println(sum1);

        // 3.Stream
        int sum = IntStream.rangeClosed(1, n).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
