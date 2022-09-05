import java.util.Scanner;

// 격차판 최대합

class Array9 {
    // 정렬 이용
    int solution(int n, int[][] arr) {
        int max = 0;
        int sum1, sum2;
        for (int i = 0; i < n; i++) {
            sum1= 0; sum2=0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max = Math.max(Math.max(sum1, sum2), max);
        }
        // 두 대각선 합
        for (int i = 0; i < 2; i++) {
            sum1 = 0; sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[j][j];
            }
            for (int j = n; j > 0; j--) {
                sum2 += arr[j - 1][j - 1];
            }
            max = Math.max(Math.max(sum1, sum2), max)
        }

        return max;
    }

    public static void main(String[] args) {
        Array9 T = new Array9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
