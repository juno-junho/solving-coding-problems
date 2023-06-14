package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String expression = bufferedReader.readLine();
        String[] split = expression.split("");
        String[] numbers = expression.split("[+-]");
        System.out.println(solution(split,numbers));
    }

    private static int solution(String[] split, String[] numberArr) {
        List<String> operator = Arrays.stream(split).filter(s -> s.equals("+") || s.equals("-")).collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(numberArr).map(Integer::parseInt).collect(Collectors.toList());

        // 무조건 + 연산 먼저 하기
        for (int i = 0; i < operator.size(); i++) {
            if (operator.get(i).equals("+")) {
                int sum = numbers.get(i) + numbers.get(i + 1);
                numbers.set(i, 0);
                numbers.set(i + 1, sum);
            }
        }
        // List가 정수형일 경우 삭제하는 경우는 removeIf 사용하기
        numbers.removeIf(integer -> integer == 0);

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        return result;

    }
}
