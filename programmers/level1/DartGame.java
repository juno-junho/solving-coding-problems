import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 정규식에 대한 학습 필요. ** 정규식과 matcher에 대해서.
// stack으로 풀어보기.. 시간이 많이 걸림.
// Pattern 과 Matcher 공부하기
public class DartGame {
    public int solution(String dartResult) {
        List<String> list = new ArrayList<>();
        String replace = dartResult.replace("10","a").replace('S', '1').replace('D', '2').replace('T', '3');
        StringTokenizer stringTokenizer = new StringTokenizer(replace,"*#",true);
        while (stringTokenizer.hasMoreTokens()) {
            String s = stringTokenizer.nextToken();
            if (s.length() == 4) {
                list.add(s.substring(0,2));
                list.add(s.substring(2));
                continue;
            }
            if (s.length() == 6) {
                list.add(s.substring(0,2));
                list.add(s.substring(2,4));
                list.add(s.substring(4));
                continue;
            }
            list.add(s);
        }
        int[] scores = new int[3];
        int index = 0;
        for (String s : list) {
            if (s.startsWith("a")) {
                scores[index] = (int) Math.pow(10, Character.getNumericValue(s.charAt(1)));
                index++;
                continue;
            }
            if (s.equals("#")) {
                scores[index - 1] *= -1;
                continue;
            }
            if (s.equals("*")) {
                scores[index - 1] *= 2;
                if (index >= 2) scores[index - 2] *= 2;
                continue;
            }
            scores[index] = (int) Math.pow(Character.getNumericValue(s.charAt(0)), Character.getNumericValue(s.charAt(1)));
            index++;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
