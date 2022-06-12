import java.util.Arrays;
import java.util.stream.IntStream;

public class AddMissingNum {
    static int solution(int[] numbers) {
        // stream으로 가능할것 같음.
        // stream이 없으면... for로 돌기..
        IntStream.rangeClosed(0,9).filter(i -> Arrays.stream(numbers).noneMatch(num -> i==num)).sum();

        // 2번째 방법. 1~9까지 모두 더하면 45이다. 여기서 numbers에 있는 숫자들 다 빼서 return 하면 된다..

//        int result = 45;
//        for (int number : numbers) {
//            result -= number;
//        }
//        return result;
        // 같은 방법을 stream으로 하면
        return 45 - IntStream.of(numbers).sum();
    }

    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(solution(numbers));

    }
}
