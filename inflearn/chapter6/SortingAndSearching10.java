import java.util.Arrays;
import java.util.Scanner;

class SortingAndSearching10 {

    // c가 동물 마리수
    int solution1(int n, int c, int[] arr) {
        int answer = 0;
        int lt = 1;
        int rt = arr[n - 1] - arr[0];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            // 끝값 제외하고 c-2 마리를 넣는다.
            for (int i = 1; i < n - 1; i++) {
            }

        }
        // n개의 마구간이 수직선 상에 있다.
        return answer;

    }

    public static void main(String[] args) {
        SortingAndSearching10 T = new SortingAndSearching10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution1(n, c, arr));
    }
}
