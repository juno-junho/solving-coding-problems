import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
// 다른방법으로 풀어보기 (시간복잡도 줄이기)

public class FindingPrimeNumber {
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
        int[] numArr = new int[num];
        Arrays.setAll(numArr,i-> sc.nextInt());
//        System.out.println("array : " + Arrays.toString(numArr));
        //IntStrem 사용 // Predicate 다시 공부해보기.
//        long primeCnt = IntStream.of(numArr).filter(FindingPrimeNumber::isPrime).count();
//        System.out.println(primeCnt);

        // 2. Stream 사용하지 않고 풀어보기
        int count = 0;
        for (int number : numArr) {
            if (isPrime(number)) count++;
        }
        System.out.println(count);
    }
}
