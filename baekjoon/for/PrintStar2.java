import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrintStar2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int starNum = sc.nextInt();
        String star = "*";
        // 풀이 1. Stream
//        IntStream.rangeClosed(1,starNum).forEach(s -> System.out.println(" ".repeat(starNum-s) + star.repeat(s)));
        IntStream.rangeClosed(1,starNum).forEach(s -> System.out.println(String.join("", Collections.nCopies(starNum - s," ")) +
                String.join("",Collections.nCopies(s,star))));

        // 풀이 2. for문
        for (int i = 0; i < starNum; i++) {
            for (int j = i; j < starNum-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
