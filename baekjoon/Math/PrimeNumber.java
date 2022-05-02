import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static boolean isPrime(int num){
        if (num == 1) return false;
        for (int i = 2; i < num ; i++) {
            if (num % i ==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        //IntStream 이용
//        IntStream primeStream = IntStream.rangeClosed(m, n).filter(PrimeNumber::isPrime);
//        if (primeStream.count() == 0){
//            System.out.println(-1);
//        }else{
//            IntStream.rangeClosed(m, n).filter(PrimeNumber::isPrime).forEach(System.out::println);
//        }

        // List사용
        List<Integer> primeList = new ArrayList<Integer>();
        while (m <=n){
            if (PrimeNumber.isPrime(m)){
                primeList.add(m);
            }
            m++;
        }
        int sum = 0;
        // list 돌면서 prime number 계속 더해주기
        for (int num:primeList) {
            sum += num;
        }
        // 출력
        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(primeList.get(0));
        }
    }
}
