import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintStar1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int starNum = sc.nextInt();
        String star = "*";
        // 1. stream 이용
        IntStream.rangeClosed(1,starNum).forEach(s -> System.out.println(String.join("", Collections.nCopies(s,star))));
        //null ("\0")를 "*"로 바꾸기
//        IntStream.rangeClosed(1,starNum).forEach(s -> System.out.println(new String(new char[s]).replace("\0",star)));
//        String repeated = new String(new char[starNum]).replace("\0", star);
//        System.out.println(repeated);
//        String collect = IntStream.rangeClosed(1, s   tarNum).mapToObj(String::valueOf).collect(Collectors.joining("*","",""))
//        System.out.println(collect);
        // 2. for문 이용
        for (int i = 0; i < starNum+1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
