import java.util.Arrays;
import java.util.Scanner;

// 순열 구하기
class DfsBfs6_answer {
    /**
     * 순열. n개 중 m개를 뽑아 일렬로 나열.
     *
     */

    static int n;
    static int m;
    static int[] arr;
    static int[] ch;
    static int[] pm;

    private void dfs(int l) {
        if (l == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[l] = arr[i];
                    dfs(l+1);
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs6_answer T = new DfsBfs6_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println(Arrays.toString(arr));

        T.dfs(0);
    }
}