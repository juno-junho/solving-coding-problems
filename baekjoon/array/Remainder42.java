import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Remainder42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        Arrays.setAll(arr, i -> sc.nextInt());
        //1. 각 요소마다 42로 나눈다
        //2. 그 것의 배열을 stream으로 만들어서 distinct(), count()해서 출력.
        long count = IntStream.of(arr).map(i -> i % 42).distinct().count();
        System.out.println(count);
    }
}
