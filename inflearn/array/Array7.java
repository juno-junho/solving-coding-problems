
import java.util.Scanner;

class Array7 {
    // 셍각하면서 코드 작성하자
    int solution(int n, int[] arr) {
        int answer = 0;
        boolean flag = false;
        int tmp = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                flag = false;
                tmp = 1;
                continue;
            }
            if (flag && arr[i] == 1) {
                tmp++;
                answer += tmp;
            } else if (arr[i] == 1) {
                flag = true;
                answer++;
            }
        }
        return answer;
    }
    // 강사 풀이
    int solution1(int n, int[] arr) {
        int answer = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) cnt = 0;

            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array7 T = new Array7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, arr));

    }
}
