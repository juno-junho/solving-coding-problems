import java.util.Scanner;

// 임시 반장 정하기.
class Array11 {
    int solution(int n, int[][] arr) {
        int answer = 0;
        return answer;
    }
    public static void main(String[] args) {
        Array11 T = new Array11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
