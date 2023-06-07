package dp;

import java.io.*;

public class 일로만들기 {

    static int[] dy;
    private int solution(int num) {
        //초기화
        dy[1] = 0;
        for (int i = 2; i <= num; i++) {
            dy[i] = dy[i - 1] + 1;
            if (i % 2 == 0) {
                dy[i] = Math.min(dy[i],dy[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dy[i] = Math.min(dy[i],dy[i / 3] + 1);
            }
        }
        return dy[num];
    }

    public static void main(String[] args) throws IOException {
        일로만들기 main = new 일로만들기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        dy = new int[num + 1];
        String result = String.valueOf(main.solution(num));

        bw.write(result);
        bw.close();
    }
}
