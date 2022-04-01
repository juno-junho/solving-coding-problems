import java.util.Scanner;

public class BreakEvenPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // x대를 판매 한다고 했을때,

        if (b >= c) System.out.println(-1);
        else {
            int x =a / (c-b) +1;
            System.out.println(x);
        }
    }
}
