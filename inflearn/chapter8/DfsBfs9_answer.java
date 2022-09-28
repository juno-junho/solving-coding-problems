import java.util.*;

// 조합 구하기 -> 거의 외우기.
class DfsBfs9_answer {

    static int n;
    static int m;
    static int[] combi;

    // 변수 s, 즉 start 순서 부터 돈다.
    private void dfs(int l, int s) {
        if (l == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[l] = i;
                dfs(l + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs9_answer T = new DfsBfs9_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        T.dfs(0, 1);

    }
}