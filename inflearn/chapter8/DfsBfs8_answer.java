import java.util.Scanner;

// 수열 추측하기
class DfsBfs8_answer {

    static int n;
    static int f;
    static int[] b;
    static int[] p;
    static int[] ch;
    static int[][] dy;
    static boolean flag = false;

    private int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else {
            dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
            return dy[n][r];
        }
    }



    private void dfs(int l, int sum) {
        if (flag) return;
        if (l == n) {   // 순열 완성
            if (sum == f) {
                flag = true;
                for (int x : p) {
                    System.out.print(x + " ");
                }
            }

        } else {
            // 순열 만들기. i 자체가 index번호가 아닌 숫자 -> ch배열이 n+1만큼 만들어야 하는 이유
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    dfs(l + 1, sum + (p[i] * b[i]));
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs8_answer T = new DfsBfs8_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        dy = new int[n][n];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        T.dfs(0, 0);
    }
}