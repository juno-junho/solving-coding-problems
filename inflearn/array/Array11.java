import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Array11 {
    int solution(int n, int[][] arr) {
        int answer = 1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            // 학년별 set
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                // 세로로 돌아서 값 비교
                for (int k = 0; k < n; k++) {
//                    System.out.println("arr[i][j] : " + arr[i][j] + ", arr[k][j] : " + arr[k][j]);
                    if (i == k) continue;
                    if (arr[i][j] == arr[k][j]) set.add(k + 1);
                }
            }
//            System.out.println((i+1) + " " + set);
            if (set.size() > max) {
                max = set.size();
                answer = i+1;
            }
        }
        return answer;
    }
    int solution1(int n, int[][] arr) {
        System.out.println(Arrays.deepToString(arr));

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max){
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Array11 T = new Array11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[][] arr = new int[n][5];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 5; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
        int[][] arr = new int[n+1][5+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution1(n, arr));
    }
}