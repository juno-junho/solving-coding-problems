import java.util.Arrays;
import java.util.Scanner;

class DfsBfs4 {

    static int n;
    static int answer = Integer.MIN_VALUE;
    static int m;
    static int[] arr;
    private void dfs(int l, int level) {
        if (level == m + 1) {
            System.out.println(Arrays.toString(arr));

        } else {
            for (int i = 1; i <= n; i++) {
                level++;
                arr[level - 1] = i;
                dfs(l + i, level);
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs4 T = new DfsBfs4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.dfs(0, 1);
        System.out.println(answer);
    }
}
