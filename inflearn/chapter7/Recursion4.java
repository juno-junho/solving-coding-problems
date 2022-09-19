import java.util.Scanner;

class Recursion4 {
    /**
     * fibonacci 수열
     * 아래코드 같이 작성하면 n = 45 같이 큰 숫자일때 매우 느리다.
     * 기록을 받아서 저장해놓으면 된다.
     *
     * memorization
     *
     * 재귀 vs for문 중에 for문이 성능이 더 좋다
     * 재귀는 stack frame이 생긴다. 메모리에 frame이 엄청 생긴다.
     * for문은 그 함수 frame 하나만 생기는 것이다.
     * 그래서 성능이 더 안좋다.
     */
    int dfs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return dfs(n - 1) + dfs(n - 2);
    }

    static int[] fibo;
    int dfs1(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        if (n == 2) return fibo[n] = 1;
        else return fibo[n] = dfs1(n - 2) + dfs1(n - 1);
    }

    public static void main(String[] args) {

        Recursion4 T = new Recursion4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for (int i : T.solution(n)) System.out.print(i + " ");
        long t1 = System.currentTimeMillis();
        fibo = new int[n + 1];
        T.dfs1(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
        long t2 = System.currentTimeMillis();
//        for (int i = 1; i <= n; i++) {
//            System.out.print(T.dfs(i) + " ");
//        }

    }
}
