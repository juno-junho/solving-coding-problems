import java.util.Scanner;

class DfsBfs3_answer {

    static int n;
    static int answer = Integer.MIN_VALUE;
    static int m;

    private void dfs(int l, int timeSum, int scoreSum, int[] score, int[] time) {
        if (timeSum > m) return;
        if (l == n) {
            answer = Math.max(answer, scoreSum);
        } else {
            dfs(l + 1, timeSum + time[l], scoreSum + score[l], score, time);
            dfs(l + 1, timeSum, scoreSum, score, time);
        }
    }
    public static void main(String[] args) {
        DfsBfs3_answer T = new DfsBfs3_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] score = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        T.dfs(0, 0, 0, score, time);
        System.out.println(answer);
    }
}
