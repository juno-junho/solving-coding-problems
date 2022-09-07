import java.util.Scanner;
// 해결못한 문제. 다시 해결해보기.

class Array12 {
    // 멘토링
    int solution(int n, int m, int[][] arr) {
        // 힌트 : 4증 for문을 돌아야 한다.
        // 전체 경우의 수 : n*(n-1)
        // 전체경우의수 - 해당 경우의 수 빼기 ?  x
        // 각 인원 마다 전체 인원 세팅해두고 돌면서 자기보다 앞에 있는 인원 배열에서 지우기.
        // 첫줄에서 내 앞에 있는 것 인원별로 배열이나 list 에 넣어 둔 후, 돌면서 자기보다 성적 안좋으면 list에서 지우기.
        // 그런데 n개의 배열을 만들 수도 없고

        // n번째 인덱스 :
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                // 위에서 멘토 : 멘티 = i : j
                boolean flag = true; // count ++ 해서 count == m 이라고 마지막에 체크해 줄수도 있다.
                int count = 0;
                for (int k = 0; k < m; k++) {
                    int num1 = 0, num2 = 0;
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i) num1 = l;
                        if (arr[k][l] == j) num2 = l;
                    }
                    if (num1 > num2) flag = false;
                    if (num1 < num2) count++;
                }
                if (flag) answer++;
                if (count == m) answer++;
            }
        }
        return answer;
    }

    // 강사 풀이
    // 총 경우인 멘토-멘티 만들수 있는 경우의수를 다 확인 해 봐야한다.
    // 총 경우의 수 : n * n
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
