import java.util.Scanner;

public class PrimeNumber3 {
    public static boolean isPrime(int num){
        if (num <= 1) return false;
        for (int i = 2; i < Math.sqrt(num) ; i++) {
            if (num % i ==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            if (isPrime(i)) System.out.println(i);
        }

    }
}
