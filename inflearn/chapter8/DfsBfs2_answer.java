import java.util.Scanner;

// 바둑이 승차
class DfsBfs2_answer {
    // 부분집합 문제와 똑같다.

    static int n = 0;
    static int c;
    static int answer = Integer.MIN_VALUE;

    private void dfs(int l, int sum, int[] arr) {
        if (sum > c) return;
        if (l == n) {
            // 최댓값 처리 어캐 해주냐
            answer = Math.max(answer, sum);
        } else{
            dfs(l + 1, sum + arr[l], arr);
            dfs(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        DfsBfs2_answer T = new DfsBfs2_answer();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.dfs(0, 0, arr);
        System.out.println(answer);
    }
}
