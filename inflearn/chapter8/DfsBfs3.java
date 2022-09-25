import java.util.Scanner;

// 최대점수 구하기
class DfsBfs3 {
    // 강사 풀이와 내 풀이가 일치함.
    static int n;
    static int answer = Integer.MIN_VALUE;
    static int m;
    static int[] score;
    static int[] time;

    private void dfs(int l, int timeSum, int scoreSum) {
        if (timeSum > m) return;
        if (l == n) {
            answer = Math.max(answer, scoreSum);
        } else {
            dfs(l + 1, timeSum + time[l], scoreSum + score[l]);
            dfs(l + 1, timeSum, scoreSum);
        }
    }

    public static void main(String[] args) {
        DfsBfs3 T = new DfsBfs3();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
//        map = new HashMap<>();
//        for (int i = 0; i < n; i++) map.put(sc.nextInt(), sc.nextInt());
        //hashMap을 못쓰는이유 : index가 보존되어 있어야 한다.
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        T.dfs(0, 0, 0);
        System.out.println(answer);
    }
}
