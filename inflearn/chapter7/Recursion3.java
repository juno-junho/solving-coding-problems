import java.util.Scanner;

class Recursion3 {
    /**
     * factorial 강사 풀이
     *
     */
    int dfs(int n) {
        if (n == 1) return 1;
        else {
            return n*dfs(n - 1);
        }
    }

    public static void main(String[] args) {

        Recursion3 T = new Recursion3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for (int i : T.solution(n)) System.out.print(i + " ");
        T.dfs(n);
    }
}
