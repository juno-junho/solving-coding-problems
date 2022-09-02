import java.util.Scanner;

// 다시 해보기
class Sequence {
    int solution(int n, int m, int[] arr){
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum > m){
                sum -= arr[lt++];
                if (sum== m) answer++;
            }
        }
        return 1;

    }
    // 강사 풀이
    int solution1(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        // 증가하고 더하고 확인
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum > m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Sequence T = new Sequence();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(T.solution(n,m,a));

    }
}
