import java.util.Arrays;
import java.util.Scanner;

public class OX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        String[] oxArray = new String[testNum];
        Arrays.setAll(oxArray, i -> sc.next());
        // String 배열을 돌면서 문자열 string에서 o가 연속하는 개수를 찾는다.

        //for

        // sequential i-1, i 모두 o이면 sequential++. 매번 i 돌때마다 sequential값 score에 누적.
        for (String oxString : oxArray) {
            // 방법 1. if문으로 o, oo, ooo, match하는 것 -> 문자열이 어느정도 길어질지 모름. 따라서 불가능.
            // 방법 2. o를 만나면 1씩 값을 ++, x를 만나면 값 초기화

            //1.첫번째가 O면 seq +1
            int score = 0;
            int sequential = 0;
            if (oxString.charAt(0) == 'O') sequential ++; score += sequential;
            for (int i =1 ; i < oxString.length(); i++) {
                // 각 string마다의 문자열 하나씩 돌면서 o이면 +1, 지난번이 O이번 sequential ++
                if (oxString.charAt(i - 1) == 'O' && oxString.charAt(i) == 'O'){
                    sequential++;
                    score += sequential;
                }else if (oxString.charAt(i) == 'O') {
                    sequential = 1;
                    score += sequential;
                }
            }
            System.out.println(score);
        }
    }
}
