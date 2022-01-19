import java.util.Scanner;
import java.util.stream.IntStream;

public class PrintN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        IntStream.rangeClosed(1,n).forEach(System.out::println);
    }
}
