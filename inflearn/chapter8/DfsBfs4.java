import java.util.Scanner;

// 나의 풀이 문제 : arr를 선언해놓고 전혀 사용하지 않았다.
class DfsBfs4 {
    /**
     * m번 칸에 중복으로 1 ~ n까지 들어갈 수 있다.
     * n = 3, m = 2라고 하면 d(0)이라고 하면 pm[L] = i로 들어가는 것.
     *
     */

    static int n;
    static int m;
    static int[] arr;
    private void dfs(int l, int level, String str) {
        if (level == m) {
            System.out.println(str);
        } else {
            level++;
            for (int i = 1; i <= n; i++) {
                dfs(i, level, str + i + " ");
            }
        }
    }
    private void dfs(int l) {
        if (l == m) {
        } else {
            for (int i = 1; i <= n; i++) {
                arr[l] = i;
                dfs(i + 1);
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs4 T = new DfsBfs4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.dfs(0, 0, new String());
    }
}