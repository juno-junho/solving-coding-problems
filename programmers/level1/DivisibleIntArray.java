import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisibleIntArray {
    static int[] solution(int[] arr, int divisor) {
        // list
        List<Integer> divisibleNumerList = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) divisibleNumerList.add(i);
        }
        if (divisibleNumerList.size() == 0) return new int[]{-1};

        divisibleNumerList.sort(Integer::compareTo);
        int[] result = new int[divisibleNumerList.size()];
        for (int i = 0; i < divisibleNumerList.size(); i++) {
            result[i] = divisibleNumerList.get(i);
        }
       return result;
    }
    static int[] solution2(int[] arr, int divisor) {
        // 위 list를 array로 바꾸는 방법
        int count = 0;
        for (int i : arr) {
            //개수
            if (i % divisor == 0) count++;
        }
        if (count == 0) return new int[]{-1};

        int[] result = new int[count];
        int resultIndex = 0;
        for (int i : arr) {
            if (i % divisor == 0) result[resultIndex++] = i;
        }
        Arrays.sort(result);
        return result;
    }
    static int[] solution3(int[] arr, int divisor) {
        // stream으로 풀이
        int[] answer = Arrays.stream(arr).filter( i -> i % divisor==0).toArray();
        if (answer.length ==0) return new int[]{-1};
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
    }
}
