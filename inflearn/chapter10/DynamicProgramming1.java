import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming1 {

    /**
     * @param args
     * 계단을 오를 때 한 번에 한 계단 또는 두 계단 씩 올라간다.
     * 만약 총 4계단을 오르면 밥법의 수는 5가지 이다.
     * 총 N 계단일 때, 올라갈 수 있는 방법의 수는?
     */

    private static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n];
    }

    public static void main(String[] args) throws IOException {
        DynamicProgramming1 main = new DynamicProgramming1();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int n = Integer.parseInt(input);
        dy = new int[n + 1];

        System.out.println(main.solution(n));
    }
}
