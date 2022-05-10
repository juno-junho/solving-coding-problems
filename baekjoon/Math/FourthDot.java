import java.util.Scanner;

public class FourthDot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 3개 입력 받아서 같은것 아닌 하나 출력하면 된다.
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int x4, y4;
        if (x1==x2) x4 = x3;
        else if (x1 == x3) x4 = x2;
        else x4 = x1;

        if (y1==y2) y4 = y3;
        else if (y1 == y3) y4 = y2;
        else y4 = y1;

        System.out.println(x4 + " " + y4);

    }
}
