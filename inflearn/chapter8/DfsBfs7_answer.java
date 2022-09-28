import java.util.Scanner;

/**
 * 조합의 경우수 (메모이제이션)
 * 5C3 = 4C2 + 4C3
 * -> {1,2,3,4,5}가 있을때 중복없이 3개 뽑는 경우의 수는,
 * 1을 기준으로 1이 포함되어있을때 (나머지 4개중에 2개 뽑기 : 4C2) + 1이 포함되어 있지 않을때 (나머지 4개중 3개 뽑기 : 4C3).
 * 피보나치 처럼 하면되고 2차원 배열을 통해서 memorization 사용하면 더 시간 줄어든다.
  */

class DfsBfs7_answer {

    static int n;
    static int r;
    int[][] dy = new int[35][35];

    private int dfs(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }


    public static void main(String[] args) {
        DfsBfs7_answer T = new DfsBfs7_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        System.out.println(T.dfs(n, r));

    }
}