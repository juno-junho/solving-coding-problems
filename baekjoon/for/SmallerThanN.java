import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SmallerThanN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        // 1. Stream
        IntStream.of(arr).filter(i -> i < x).forEach(System.out::println);

        // 2. arr for문 돌면서 작은것만 if()문으로 출력
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] < x) System.out.println(arr[i]);
        }
    }
}
