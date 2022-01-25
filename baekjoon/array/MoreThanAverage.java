import java.util.Arrays;
import java.util.Scanner;

public class MoreThanAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        int[] testArray = new int[testNum];
        Arrays.setAll(testArray, i -> sc.nextInt());

        //각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
    }

}
