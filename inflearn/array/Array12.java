import java.util.Scanner;
class Array12 {
    // 멘토링
    int solution(int n, int m, int[][] arr) {
        // 힌트 : 4증 for문을 돌아야 한다.
        // 전체 경우의 수 : n*(n-1)
        // 전체경우의수 - 해당 경우의 수 빼기 ?  x
        // 각 인원 마다 전체 인원 세팅해두고 돌면서 자기보다 앞에 있는 인원 배열에서 지우기.
        // 첫줄에서 내 앞에 있는 것 인원별로 배열이나 list 에 넣어 둔 후, 돌면서 자기보다 성적 안좋으면 list에서 지우기.
        // 그런데 n개의 배열을 만들 수도 없고
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        int answer =0;
        return answer;
    }
    public static void main(String[] args) {
        Array12 T = new Array12();
        Scanner sc = new Scanner(System.in);
        // 인원 수
        int n = sc.nextInt();
        // 테스트 수
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, m, arr));
    }
}
// 해결못한 문제. 다시 해결해보기.
