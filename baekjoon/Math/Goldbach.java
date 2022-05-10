import java.util.Scanner;

public class Goldbach {
    public static boolean isPrime(int num){
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();
            if (num % 2 != 0) break;
            // 두 수가 소수
            // num을 반으로 나눠 소수면 num - 수 도 소수인것 확인 후 출력
            // 아니면 +1 증가 똑같이 반복.
            int partition1 = num / 2;
            int partition2 = num - partition1;

            while (!isPrime(partition1) || !isPrime(partition2)){
                if (!isPrime(partition1)) {
                    partition1++;
                    partition2 = num - partition1;
                }if (!isPrime(partition2)){
                    partition1++;
                    partition2 = num -partition1;
                }
            }
            System.out.println(partition2 + " " + partition1);
            // num 까지 소수 중에 반으로 나눠서 -> 대응하는것 있으면 출력. 없으면 다음으로 이동.
        }
    }
}
