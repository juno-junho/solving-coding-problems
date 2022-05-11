import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];
        Arrays.setAll(cards, i-> sc.nextInt());

        // cards를 통해 뽑을 수 있늕 3장 모든 경우의 수 합에서, m 넘는것 버리고 제일 큰것을 출력
        int sum = 0;
        int max = 0;
        for (int a : cards) {
            for (int b: cards) {
                if (b == a) continue;
                for (int c: cards) {
                    if (c == a || c == b) continue;
                    sum = a + b+ c;
                    if (sum <=m && sum > max) {
                        max = sum;
                    }
                    if (max == m) break;
                }
            }
        }
        System.out.println(max);
    }
}
