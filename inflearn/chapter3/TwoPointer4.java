import java.util.Arrays;
import java.util.Scanner;

class TwoPointer4 {
    int solution(int n) {
        int answer = 0;
        // 연속된 자연수의 합 : 똑같이 1부터 증가해나가면서 n보다 sum이 커지면 또다른 포인터 sum에서 앞쪽부터 하나씩 지워가기.
        int p2 = 1;
        int sum = 0;
        for (int p1 = 1; p1 <= n/2 + 1; p1++) {
            sum += p1;
            if (sum == n) answer++;
            while (sum > n) {
                sum -= p2;
                p2++;
                if (sum == n) answer++;
            }
        }
        return answer;

    }


    public static void main(String[] args) {
        TwoPointer4 T = new TwoPointer4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }

}
