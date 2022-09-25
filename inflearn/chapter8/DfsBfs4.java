import java.util.Arrays;
import java.util.Scanner;

class DfsBfs4 {

    static int n;
    static int answer = Integer.MIN_VALUE;
    static int m;
    static int[] arr;
    private void dfs(int l, int level) {
        StringBuilder sb = new StringBuilder();
        if (level == m) {
            System.out.println(sb.toString());
            sb = new StringBuilder();
        } else {
            level++;
            for (int i = 1; i <= n; i++) {
                dfs(i, level);
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs4 T = new DfsBfs4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.dfs(0, 0);
        System.out.println(answer);
    }
}