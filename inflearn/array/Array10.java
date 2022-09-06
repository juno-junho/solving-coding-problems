import java.util.Scanner;

// 봉우리 문제
// 강사 풀이 잘 기억하기.
class Array10 {
    int solution(int n, int[][] arr) {
        int answer = 0;
        // 나는 가장자리 예외처리를 하지 못했고 한번 더 돌았다.
        int[][] arr2 = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr2[i][j] = arr[i - 1][j - 1];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if ((arr2[i][j] > arr2[i + 1][j]) && (arr2[i][j] > arr2[i][j + 1]) &&
                        (arr2[i][j] > arr2[i - 1][j]) && (arr2[i][j] > arr2[i][j - 1])) answer++;
            }
        }
        return answer;
    }
    // 강사 풀이. 가장자리 예외를 어떻게 처리하는지 몰랐음.
    // dx dy 배열로 만드는 이유는 비교하는게 4개가 아니라 대각선 까지 8개로 늘어나면 if 쓰는것 보다 이렇게 추가하는게 더 보기 좋음.
    int solution1(int n, int[][] arr) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array10 T = new Array10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution1(n, arr));
    }
}
