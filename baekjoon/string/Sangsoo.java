import java.util.Scanner;

public class Sangsoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuffer firstNum = new StringBuffer().append(sc.nextInt()).reverse();
        StringBuffer secondNum = new StringBuffer().append(sc.nextInt()).reverse();

        if (Integer.parseInt(String.valueOf(firstNum)) > Integer.parseInt(String.valueOf(secondNum))) System.out.println(firstNum);
        else System.out.println(secondNum);
        // int를 reverse하는 방법.
        // 1. Intstream 이용
        /* Integer::reverse는 비트수를 reverse하는것이기 때문에 사용할 수 없음.*/
//        for (int i = 0; i < firstNum.length ; i++) {
//            StringfirstNum[i]
//        }
    }
}
