package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2230 {

    private static int solution(int n, int m, int[] arr) {

        int p1 = 0;
        int p2 = 0;
        int answer = Integer.MAX_VALUE;
        while (p1 < n && p2 < n) {
            if (Math.abs(arr[p1] - arr[p2]) >= m) {
                answer = Math.min(answer, Math.abs(arr[p1] - arr[p2]));
                p2++;
            } else {
                p1++;
            }
        }
        // arr 돌면서
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(arr);
        System.out.println(solution(N,M,arr));
    }
}
