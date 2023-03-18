import java.util.HashMap;
import java.util.Map;

public class YunsikEx {

    /**
     * 알파벳 소문자로 이루어진 문자열이 있을때,
     * 알파벳을 짝수 개수로 맞출 때, 삭제해야하는 개수를 반환하라.
     */

    public static int solution(String str) {
        int count = 0;
        int[] alphabetArr = new int[26];
        char[] chars = str.toCharArray();

        for (char letter : chars) {
            alphabetArr[letter - 'a']++;
        }
        for (int alphabet : alphabetArr) {
            if (alphabet % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int solution2(String str) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char letter : chars) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abcccadef";
        int solution = solution2(str);
        System.out.println(solution);
    }
}
