import java.util.Arrays;

public class NNumSpacedByX {
    static long[] solution(int x, int n) {
        int add = x;
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = x;
            x += add;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4,3)));
        System.out.println(Integer.MAX_VALUE);
    }
}
