import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming2 {

    /**
     * 돌다리 건너기
     * n개의 돌다리. 한번에 한 칸 또는 두칸씩.
     * 철수가 개울을 건너는 방법의 수를 구하시오
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
        DynamicProgramming2 main = new DynamicProgramming2();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int n = Integer.parseInt(input);
        dy = new int[n + 2];

        System.out.println(main.solution(n + 1));
    }
}
