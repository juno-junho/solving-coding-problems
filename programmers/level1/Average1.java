import java.util.stream.IntStream;

public class Average1 {
    static double solution(int[] arr) {
        // 2. Stream API 이용
        return IntStream.of(arr).average().getAsDouble();
    }
    static double solution2(int[] arr) {
        // 1. 평균 공식 대로 arr for문돌아 다 돌면서 arr.length로 나누기
        double sum = 0.0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }
    public static void main(String[] args) {


    }
}
