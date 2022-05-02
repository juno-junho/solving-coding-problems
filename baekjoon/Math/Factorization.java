import java.util.Scanner;

public class Factorization {
    public static boolean isPrime(int num){
        if (num == 1) return false;
        for (int i = 2; i < num ; i++) {
            if (num % i ==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // 소인수 분해
        // while문 돌면서  2로나눈다 (최소의 소수)
        // 떨어지면 -> 다시 반복한다
        // 나누어 떨어지 않는다 -> 소수 증가시킨다
        int primenum = 2;
        while (num >= primenum){
            if (!Factorization.isPrime(primenum)) primenum++;
            // 소수로 나눈다. 나누어 떨어지면 다시 반복
            if (num % primenum == 0) {
                System.out.println(primenum);
                num = num / primenum;
//                System.out.println("num" + num);
            }else {
                primenum ++;
            }
        }
    }
}
