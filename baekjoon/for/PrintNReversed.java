import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrintNReversed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1. stream 이용
        IntStream.rangeClosed(1,n).boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);

        // 2. for문
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }

    }
}
