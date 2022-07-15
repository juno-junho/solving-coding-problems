import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerReversedArray {
    static int[] solution(long n) {
        // 1. 전형적인 방법.
        int[] answer = new int[String.valueOf(n).length()];
        for (int j = 0; j < answer.length ; j++) {
            answer[j] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
    static int[] solution2(long n) {
        // 1. stream을 이용한 방법
        StringBuilder reverse = new StringBuilder(String.valueOf(n)).reverse();
        String[] split = new String(reverse).split("");
        return Stream.of(split).mapToInt(Integer::parseInt).toArray();

    }
    static int[] solution3(long n) {
        // 1. stream을 이용한 방법
       return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1230400000)));
    }

}
