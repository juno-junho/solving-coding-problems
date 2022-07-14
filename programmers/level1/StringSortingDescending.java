import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSortingDescending {
    static String solution(String s) {
        // s를 큰 것 부터 작은순으로 정렬해 새로운 문자열 리턴 함수. solution
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
//        for (int i = 0; i < chars.length/2; i++) {
//            char temp = chars[i];
//            chars[i] = chars[chars.length -1 -i];
//            chars[chars.length -1 -i] = temp;
//        }
        return new StringBuilder(new String(chars)).reverse().toString();
//        return new String(chars);
    }
    static String solution2(String s) {
        // stream 이용
        return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        solution("Zbcdefg");
    }
}
