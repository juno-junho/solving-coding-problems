import java.util.ArrayList;
import java.util.List;

public class Ternary {
    // Integer.parseInt 사용할때, 매개변수 2개 넘기면 두번째 진수로 변환함.
    static int solution(int n) {
        // n을 3으로 계속해서 나누면 된다.
        List<Integer> arr = new ArrayList<>();
//        do {
//            arr.add(n % 3);
//            n /= 3;
//        } while ( n != 0);
        while (n != 0){
            arr.add(n % 3);
            n /= 3;
        }

        int answer = 0;
        for (int i = 0; i < arr.size() ; i++) {
           answer += arr.get(arr.size()-1-i) * Math.pow(3,i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
    }
}
