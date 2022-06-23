import java.util.stream.IntStream;

public class RemainderOne {
    static int solution(int n) {
        int answer = 0;
        //n % x  == 1인
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        // stream으로 풀기
//        IntStream.range(2,n).filter(i -> n % i == 1).findFirst().orElse(0);

        return answer;
    }

    public static void main(String[] args) {

    }
}
