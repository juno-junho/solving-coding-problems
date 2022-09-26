import java.util.Arrays;
import java.util.Scanner;

// 동전 교환 문제 -> bfs로 해결
class DfsBfs5 {
    /**
     * 여러 단위의 동전들이 주어졌을때, 거스름돈을 가장 적은 동전의 수로 교환 해주려면?
     * 첫쨋줄에 거슬러 줄 동전의 최소 개수를 출력한다.
     */

    static int n;
    static int m;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    private void dfs(int l, int level, int sum) {
        if (level >= min) return;
        if (sum > m ) return;
        if (sum == m) {
            min = Math.min(min, level);
            return;
        } else {
            level++;
            for (int i = arr.length - 1; i >= 0; i--) {
                dfs(arr[i], level, sum + arr[i]);
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs5 T = new DfsBfs5();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        m = sc.nextInt();
        T.dfs(0, 0, 0);
        System.out.println(min);
    }
}