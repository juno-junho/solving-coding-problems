import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1. while돌면서 합 구하기 -> int범위 넘어가면 사용 불가능
//        int number = sc.nextInt();
//        int sum = 0;
//        while(!(number==0)){
//            sum += number % 10;
//            number /= 10;
//        }
//        System.out.println(sum);
        // 2. n이 100까지 가능하므로 string[]으로 받아서 각 자리 숫자로 변환해 더한다.
        // Stringtokenizer를 써야 하나 생각했다. 하지만 한 문자열을 하나하나씩 구분하진 못하는것 같다.
        String number = sc.next();
        int sum = 0;
        String[] split = number.split("");
        for (String num:split) {
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);

    }
}
