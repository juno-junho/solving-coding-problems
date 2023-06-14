package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541_answer {
    private static int solution(String[] expression) {
        int result = 0;
        for (int i = 0; i < expression.length; i++) {
            if (i == 0) {
                result += calculate(expression[i]);
            }
            else result -= calculate(expression[i]);
        }
        return result;
    }

    private static int calculate(String expression) {
        String[] split = expression.split("[+]");
        int result = 0;
        for (String numStr : split) {
            result += Integer.parseInt(numStr);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String expression = bufferedReader.readLine();
        String[] numbers = expression.split("[-]");
        System.out.println(solution(numbers));
    }
}
