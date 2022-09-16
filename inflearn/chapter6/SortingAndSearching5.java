import java.util.Arrays;
import java.util.Scanner;

class SortingAndSearching5 {

    // 강사풀이와 내풀이가 같음.
    int[] solution(int[] arr, int n) {
        int[] answer = new int[2];
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            // i번째와 i+1 비교해서 i+1 더 작으면 index 반환
            // 예외 : i보다 i+1이 작을때, arr[i]랑 같은 키 중 가장 앞 인덱스 반환 // 거꾸로 돌기..
            if (arr[i] > arr[i + 1]) {
                if (!flag) {
                    answer[0] = i + 1;
                    flag = true;
                } else if (flag) {
                    answer[1] = i + 2;
                }
            }
        }
        // 예외처리
        if (answer[1] == 0) {
            answer[1] = answer[0] + 1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[answer[1]-2]) {
                    answer[0] = i + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SortingAndSearching5 T = new SortingAndSearching5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : T.solution(arr, n)) System.out.print(i + " ");
    }
}
