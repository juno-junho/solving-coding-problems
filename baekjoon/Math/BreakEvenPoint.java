import java.util.Scanner;

public class BreakEvenPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        long x = 0;
        // x대를 판매 한다고 했을때,
        if (b > c) System.out.println(-1);
        else {
            while (a + b * x >= c * x) {
                x++;
            }
            System.out.println(x);
        }
    }
}
