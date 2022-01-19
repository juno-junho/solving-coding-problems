import java.util.Scanner;
import java.util.stream.IntStream;

public class TimesTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 1. stream이용
//        IntStream.range(1,10).forEach(s -> System.out.println(num + " * " + s + " = " + s*num));

        // 2. for문 이융
        for (int i = 1; i < 10; i++) {
            System.out.println(num + " * " + i + " = " + num*i);
        }
    }
}

