package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1026 {
    // O(NlogN)
    private static int soultion(int n, Integer[] a, Integer[] b) {
        Arrays.sort(b);
        Arrays.sort(a, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
            B[i] = Integer.parseInt(stringTokenizer2.nextToken());
        }
        System.out.println(soultion(N, A, B));

    }
}
