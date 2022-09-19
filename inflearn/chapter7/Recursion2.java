import java.util.Scanner;

class Recursion2 {
    /**
     * 11이 오면 로 나눠 나머지 출력
     */
    void dfs(int n) {
        int remainder = n % 2;
        if (n == 0) {
            System.out.print("");
            return;
        }
        dfs(n / 2);
        System.out.print(remainder + "");
    }

    /**
     * 강사 풀이
     d(0) --------- return 으로 pop
     d(1) -- line 6    1
     d(2) -- line 6    0
     d(5) -- line 6    1
     d(11)-- line 6    1f
     */

    void dfs1(int n) {
        if (n == 0) return;
        else{
//            System.out.print(n % 2 + "");
            dfs(n / 2);
            System.out.print(n % 2 + "");
        }
    }

    public static void main(String[] args) {

        Recursion2 T = new Recursion2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for (int i : T.solution(n)) System.out.print(i + " ");
        T.dfs1(n);
    }
}
