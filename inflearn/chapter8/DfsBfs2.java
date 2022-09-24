import java.util.Scanner;

// 바둑이 승차
class DfsBfs2 {
    // 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우 존재시 YES. 없으면 NO 출력

    static int n = 0;
    static int[] ch;
    static int max = 0;

    private void dfs(int l, int c, int[] arr) {
        if (l == n) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 1) sum += arr[i];
            }
            if (sum > c) return;
            max = Math.max(max, sum);
            return;
        }
        ch[l] = 1;
        dfs(l + 1, c, arr);
        ch[l] = 0;
        dfs(l + 1, c, arr);

    }


    public static void main(String[] args) {
        DfsBfs2 T = new DfsBfs2();
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        n = sc.nextInt();
        ch = new int[n + 1];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.dfs(0, c, arr);
        System.out.println(max);

    }

}
