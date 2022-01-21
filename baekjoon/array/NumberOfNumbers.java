import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] numArr = {0,0,0,0,0,0,0,0,0,0};
        // a*b*c를 valueof로 string 변환. 변환된 string을 쪼개서 배열에 담고 각 수마다 for문 돌려서 찾기
        String[] arr = String.valueOf(a*b*c).split("");
        for (String num : arr) {
            if (num.equals("0")) numArr[0] += 1;
            if (num.equals("1")) numArr[1] += 1;
            if (num.equals("2")) numArr[2] += 1;
            if (num.equals("3")) numArr[3] += 1;
            if (num.equals("4")) numArr[4] += 1;
            if (num.equals("5")) numArr[5] += 1;
            if (num.equals("6")) numArr[6] += 1;
            if (num.equals("7")) numArr[7] += 1;
            if (num.equals("8")) numArr[8] += 1;
            if (num.equals("9")) numArr[9] += 1;
        }
        for (int number: numArr) {
            System.out.println(number);
        }
        // stream
    }
}
