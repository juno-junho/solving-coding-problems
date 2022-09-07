import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Array11 {
    // 꼭 for문안에 for문이 있다고해서 종속적인것이 아님. 동등한 위치여도 된다. n*n == 이중 for문
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
                answer = i + 1;
            }
        }
        return answer;
    }
    // 강사 풀이ㅎ
    int solution1(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            // i번 학생이 j번 학생과 같은반한 인원은 몇명있는지
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                // k는 학년
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) { // i학생과 j 학생이 k반에서 같은반인 경우
                        cnt++;
                        // 같은경우 j학생을 한번만 counting해줘야 한다.
                        break;
                    }
                }
            }
            if (cnt > max) {
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
        int[][] arr = new int[n + 1][5 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution1(n, arr));
    }
}