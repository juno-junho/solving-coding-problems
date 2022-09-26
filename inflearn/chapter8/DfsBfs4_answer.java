import java.util.Scanner;

class DfsBfs4_answer {

    static int n;
    static int m;
    static int[] pm;
    private void dfs(int l){
        if (l == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                dfs(l + 1);
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs4_answer T = new DfsBfs4_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.dfs(0);
    }
}