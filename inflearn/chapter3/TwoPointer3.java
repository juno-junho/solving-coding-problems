import java.util.Arrays;
import java.util.Scanner;

class TwoPointer3 {
    int solution(int n, int m, int[] arr) {

        System.out.println(Arrays.toString(arr));
        // two pointer로 시작한다. m보다 크면 p1을 이동시키고, m보다 작으면 p2를 이동시키고, 같으면 answer++한다.
        int p2 = 0;
        int answer = 0;
        int sum = 0;
        for (int p1 = 0; p1 < n; p1++) {
            sum += arr[p1];
            System.out.println("sum = " + sum);
            if (sum == m) answer++;
            while (sum > m) {
                sum -= arr[p2];
                p2++;
                if (sum == m) answer++;
            }
        }
        return answer;

    }


    public static void main(String[] args) {
        TwoPointer3 T = new TwoPointer3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, a));
    }

}
