import java.util.Scanner;
// 소수 구하는 방법론에서는 에라토스테네스 체가 가장 빠르다 (코드 잘 기억하기)

// 이중 for문 -> 시간복잡도 높음.
class Array5 {
    public int solution(int n) {
        int answer = 0;
        boolean flag = true;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
            else flag = true;
        }
        return answer;
    }

    public int solution1(int n) {
        int answer = 0;
//        int[] ch = new int[n + 1]; // index가 n 까지의 배열 만들기.
        boolean[] ch = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if(ch [i] == false){
                answer++;
                for (int j = i; j <= n; j += i) ch[j] = true;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array5 T = new Array5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));

    }
}
