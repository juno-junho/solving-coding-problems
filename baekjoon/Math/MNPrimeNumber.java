import java.util.Scanner;

public class MNPrimeNumber {
    public static boolean isPrime(int num){
        if (num == 1) return false;
        for (int i = 2; i < num ; i++) {
            if (num % i ==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] s = num.split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        while (m <= n){
            if (MNPrimeNumber.isPrime(m)){
                System.out.println(m);
            }
            m++;
        }
    }
}
