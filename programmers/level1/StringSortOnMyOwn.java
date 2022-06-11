import java.util.Arrays;
import java.util.Comparator;

// Comparator, Comparable에 대한 확실한 학습.
public class StringSortOnMyOwn {
    // 문자열 내 마음대로 정렬하기
    static String[] solution(String[] strings, int n) {
        // n 따라 index 뽑아서 sort 한 다음에 대응하는 것. Comparator 만들어 주기..
        Comparator<String> comparator = (o1, o2) -> {
            char firstChar = String.valueOf(o1).charAt(n);
            char secondChar = String.valueOf(o2).charAt(n);
            // 오름 차순 -> 작으면 앞에 온다.  작으면 작다.
            // 같을때가 문제.
            if (firstChar == secondChar) return String.valueOf(o1).compareTo(String.valueOf(o2));
            return (Character.compare(firstChar, secondChar));
        };
        Arrays.sort(strings, comparator);
        return strings;

    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
}
