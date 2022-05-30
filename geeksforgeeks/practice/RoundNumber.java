import java.util.Scanner;

public class RoundNumber {
    static int round(int num){
        int a = (num / 10) * 10;
        int b =  a + 10;

        return num - a < b - num ? a : b;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        int num = sc.nextInt();
        // a = (num / 10) * 10 일때, b = a + 10.
        // num - a와 b - num 비교해서 더 큰 쪽 것을 return. 차이가 5면 b return

        System.out.println("Output : " + round(num));

    }
}
