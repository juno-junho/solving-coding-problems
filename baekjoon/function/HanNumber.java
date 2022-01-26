import java.util.Scanner;

public class HanNumber {
    public static void main(String[] args) {
        //어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
        // 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
        // N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

        //생각 process
        /*
        n이 주어지는데 1부터 99까지는 무조건 등차수열이다.
        백의 자리가 1 -> 111, 123, 135, 147, 159
        백의 자리가 2 -> 210, 222, 234, 246, 258
        백의 자리가 3 -> 321, 333, 345, 357, 369
        백의 자리가 4 -> 420, 432, 444, 456, 468
        백의 자리가 5 -> 531, 543, 555, 567, 579
         */
        // function으로 100 이상일 경우 자리수의 차가 일정한지 확인.
        // for돌면서 true값이면 result에서 1씩 증가. 해서 출력.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
           if(hanNum(i)){
               result++;
           }
        }
        System.out.println(result);
    }
    public static boolean hanNum(int i){
        // 차가 일정하면 true
        // 1000 제외
        if (i == 1000) return false;
        int one = i%10;
        int ten = (i/10)%10;
        int hundred = (i/100)%10;
        if (i < 100) {
            return true;
        }else return one - ten == ten - hundred;
    }
}
