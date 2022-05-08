import java.util.ArrayList;
import java.util.Scanner;

public class MNPrimeNumber2 {
    public static void main(String[] args) {

        ArrayList<Boolean> primeList;

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (n <=1 ) return;

        primeList = new ArrayList<>(n+1);
        // 0,1 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);
        // 2~n까지 소수로 일단 설정
        for (int i = 2; i <= n ; i++) {
            primeList.add(i,true);
        }
        // 2부터 i*i <=n 까지 각배수들 지워 나간다.
        for (int i = 2; (i*i) <= n; i++) {
            if (primeList.get(i)){
                // i제곱부터 i배수를 지워 나간다. (근데 왜 i제곱부터 지워나가지?)  // 와... 감탄..
                for (int j = i*i; j <= n ; j+=i) {
                    primeList.set(j,false);
                }
            }
        }

        for (int i = m; i <=n ; i++) {
            if (primeList.get(i)){
                System.out.println(i);
            }
        }
    }
}
