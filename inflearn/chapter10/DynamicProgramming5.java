import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DynamicProgramming5 {

    /**
     * // 다음과 같이 여러 단위의 동전들이 주어져 있을 때,
     * // 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
     *
     * /**
     * * 입력 :
     * * 첫 번째 줄: 동전의 종류 개수 (1 ~ 50 까지의 n이 주어진다) e.g) 3
     * * 두 번째 줄: N개의 동전의 종류 e.g) 1 2 5
     * * 세 번째 줄: 거슬러 줄 금액 M e.g) 15
     * *각 동전의 종류는 100원을 넘지 않는다.
     * *
     * * 출력 : 3 // 5 5 5 동전 3개로 거슬러 줄 수 있다.
     *
     */


    private static int[] dy;

    public int solution(int[] coins, int returnPrice) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; i <= returnPrice; i++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }
        return dy[returnPrice];
    }

    public static void main(String[] args) throws IOException {
        DynamicProgramming5 main = new DynamicProgramming5();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int coinCount = Integer.parseInt(input);
        int[] coins = new int[coinCount];
        String[] coinInputs = bf.readLine().split(" ");

        for (int i = 0; i < coinCount; i++) {
            coins[i] = Integer.parseInt(coinInputs[i]);
        }
        int returnPrice = Integer.parseInt(bf.readLine());
        dy = new int[returnPrice + 1];

        System.out.println(main.solution(coins, returnPrice));
    }
}
