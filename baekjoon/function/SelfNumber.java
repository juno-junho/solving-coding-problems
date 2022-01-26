import java.util.HashSet;
import java.util.Set;

public class SelfNumber {
    public static void main(String[] args) {
        // 생각 process : dn을 1부터 계속 넣는다.
        // dn의 수열을 만들 수는 있다. 하지만 구하는것은 수열이 아니라 self number이다.
        // 재귀로 1 넣어 수열 만든다 해도 self number를 제외한 모든 값들이 구해지는 것은 아니다.
        // self number를 구하는것은 여집합으로 구하는 방법 말고는 없지 않은가.
        // 
        // 10000 까지의 array에서
//        1 2 4 8 ... d
        // 결국 일일히 다 구해야한다. 어떤 수가 d(n)을 통해서 나올수가 없는 수가 바로 self number이다.
        // 1부터 10000까지 배열 중에 dn(i)값과 일치하는 것이 있으면 그 값을 삭제한다.
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < 10000 ; i++) {
            integerSet.add(dn(i));
        }
//        integerSet.forEach(System.out::println);
        // 1부터 100까지 중에 set과 같은 값있으면 삭제
        for (int i = 1; i <= 10000; i++) {
            if (integerSet.contains(i)){
                continue;
            }
            System.out.println(i);
        }
        
    }
    public static int dn(int number){
        // 생각 process
        // 생성자가 없는 숫자를 self number라고 한다.
        // n + 자리수를 더하는 함수 반환.
        // n 자리수 만드는 법 : 10으로나눈 나머지. while로 계속 나눈다.
        int sumOfDigits = 0;
        int originNumber = number;
        while (originNumber != 0) {
            sumOfDigits += originNumber%10;
            originNumber /= 10;
        }
        return number + sumOfDigits;
    }
}
/**
 * public class Main {
 *
 * 	public static void main(String[] args) {
 *
 * 		boolean[] check = new boolean[10001];	// 1부터 10000이므로
 *
 * 		for (int i = 1; i < 10001; i++){
 * 			int n = d(i);
 *
 * 			if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
 * 				check[n] = true;
 *                        }* 		}
 *
 * 		StringBuilder sb = new StringBuilder();
 *
 * 		for (int i = 1; i < 10001; i++) {
 * 			if (!check[i]) {	// false 인 인덱스만 출력
 * 				sb.append(i).append('\n');*                    }
 * 		}
 * 		System.out.print    (sb);
 * 	}
 *
 *
 *
 * 	public static int d(int number){
 * 		int sum = number;
 *
 * 		while(number != 0){
 * 			sum = sum + (number % 10); // 첫 째 자리수
 * 			number = number/10;	// 10을 나누어 첫 째          없앤다
 * 		}
 *
 * 		retu     sum;
 * 	}
 * }
 */
