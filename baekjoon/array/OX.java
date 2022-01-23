import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        String[] oxArray = new String[testNum];
        Arrays.setAll(oxArray, i -> sc.next());
        // 연속하는 를 찾는다.

        Stream.of(oxArray).forEach(System.out::println);


    }
}
