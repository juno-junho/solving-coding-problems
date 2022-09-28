import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 수열 추측하기
class DfsBfs8 {

    static int n;
    static int f;
    static int[] b;
    static int[][] dy;
    private int dfs(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else {
            dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
            return dy[n][r];
        }
    }


    static int[] ch;
    static int[] pm;
    static boolean flag = false;
    private void dfs(int l) {
        if (flag) return;
        if (l == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (pm[i] * b[i]);
            }
            if (sum == f) {
                flag = true;
                for (int x : pm) {
                    System.out.print(x + " ");
                }
            }

        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[l] = i;
                    dfs(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs8 T = new DfsBfs8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        dy = new int[n][n];
        for (int i = 0; i < n; i++) {
            b[i] = T.dfs(n - 1, i);
        }
        ch = new int[n + 1];
        pm = new int[n];
        T.dfs(0);
    }
}