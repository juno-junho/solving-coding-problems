import java.util.Scanner;
// 연속된 자연수의 합 -> 수학적인 방법으로 다시 한번 생각해보기.

class TwoPointer4 {
    // 내풀이 : two pointers algorithm 이용
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
    // 강사풀이 1. (two pointers algorithm)
    int solution1(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i + 1;
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }
        return answer;
    }
    // 강사풀이 2. (수학적 풀이)
    int solution2(int n) {
        // 원리 : n에서 연속된 m개의 수열이 있을때, 1 + 2 + ... m 의 합을 n에서 빼서 n/m이 나누어 떨어지면 ok
        int answer = 0;
        int count = 1;  // 연속된 자연수의 합
        n--;
        while (n > 0) {
            count++;
            n -= count;
            if (n % count == 0) answer++;
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
