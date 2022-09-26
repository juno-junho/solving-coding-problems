import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 동전 교환 문제 -> 중복 순열과 비슷함.
// 강사 풀이와 내 풀이가 비슷함.
class DfsBfs5_answer {
    static int n;
    static int m;
    static Integer[] arr;
    static int min = Integer.MAX_VALUE;
    private void dfs(int l, int sum) {
        if (l >= min) return;
        if (sum > m ) return;
        if (sum == m) {
            min = Math.min(min, l);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(i + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs5_answer T = new DfsBfs5_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        T.dfs(0, 0);
        System.out.println(min);
    }
}