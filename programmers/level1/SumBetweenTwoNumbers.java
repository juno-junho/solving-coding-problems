import java.util.stream.IntStream;

public class SumBetweenTwoNumbers {
    public long solution(int a, int b) {
        // stream이용
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        long sum = IntStream.rangeClosed(min, max).mapToLong(i -> (long) i).sum();
        return sum;
    }
    public long solution2(int a, int b) {
        // for문 이용
        long sum = 0;
        for (int i = ((a > b) ? a : b); i <=((a < b)? b : a) ; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
