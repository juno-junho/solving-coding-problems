import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        // total length : v
        // day 1 : v -a +b
        // day2 : v + (-a + b) * days
        // day 2 : v -2*a +b <0 면 2출력
        // day 3 : v -3a + 2b <0 이면 3출력
        // 1000000000 -100*n + 99*(n-1) <0 이면 n 출력
        // v - a*n + d

        // 올라가야할 길이 : v  + (-a + b) * days < 0 되는 day 구하면 됨.
        // day> -v /b-a day > x
        // 5 1 6

        System.out.println((-v/(b-a)) + 1   );
    }
}
