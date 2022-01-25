
import java.util.Arrays;
import java.util.Scanner;
public class MoreThanAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for (int i = 0; i < testNum ; i++) {
            int studentNumber = sc.nextInt();
            int[] testArray = new int[studentNumber];
            Arrays.setAll(testArray, score -> sc.nextInt());
            // 1. Stream
            // process : 평균을 구한다 -> 그것보다 큰것 개수 구한다. (filter) -> average와 비교.
//            double average = IntStream.of(testArray).mapToDouble(Double::new).average().orElse(0);
            double average = 0;
            double sum = 0;
            for (int score : testArray) {
                sum += score;
            }
            average = sum / studentNumber;

            double aboveAverageNum = 0;
            for ( int score: testArray) {
                if (score > average){
                    aboveAverageNum ++;
                }
            }
            double result = aboveAverageNum / studentNumber * 100;
            String resultRounded = String.format("%.3f", result );
            System.out.println(resultRounded + "%");
        }
    }
}