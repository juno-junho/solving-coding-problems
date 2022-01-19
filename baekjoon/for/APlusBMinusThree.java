import java.util.Scanner;

public class APlusBMinusThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loopNum = sc.nextInt();
        for (int i = 0; i < loopNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
