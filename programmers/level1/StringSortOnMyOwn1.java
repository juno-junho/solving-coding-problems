import java.util.*;

public class StringSortOnMyOwn1 {
    // 문자열 내 마음대로 정렬하기
    // 풀이방법 2. n뒤에 string을 붙혀서 sort()하면 됨. 그리고 그 결과에서 n 뗀 결과를 return하면 된다.
    static String[] solution(String[] strings, int n) {
        List<String> arr = new ArrayList<>();
        for (String string : strings) {
            arr.add(string.charAt(n) + string);
        }
        Collections.sort(arr);

        String[] answer = new String[strings.length];
        for (int i = 0; i < strings.length ; i++) {
            answer[i] = arr.get(i).substring(1);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
}
