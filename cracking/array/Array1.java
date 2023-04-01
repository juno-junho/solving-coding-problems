package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 학습할것 : 비트연산 -> 이해하기
 */
public class Array1 {

    /**
     * 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘
     * 추가적인 자료구조 사용하지 않기.
     */

    // TIME: O(N)
    // SPACE: O(N) -> chars는 제외시
    public static boolean isUniqueChars_1(String str) {
        char[] chars = str.toCharArray();
        //1 , Set 사용
        Set<Character> set = new HashSet<>();
        for (char character : chars) {
            set.add(character);
        }
        return set.size() == str.length();
    }

    // TIME: O(N^2)
    // SPACE: O(1)
    public static boolean isUniqueChars_2(String str) {
        char[] chars = str.toCharArray();
        // 추가적인 자료구조 사용 X
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) return false;
            }
        }
        return true;
    }

    /**
     * Answer
     * 1. ascii 문자열일 경우 배열 이용 -> 생각 안한것은 아닌데 문자열 전체 범위니 너무 막연해서 사용 x (0 ~ 127까지 존재)
     * 2. 비트 백터 활용. -> 필요 공간 1/8로 줄임.
     * 3. 정렬 후 인접한 문자 동일한지 검사
     */
    // TIME : O(N)
    // SPACE : O(1) -- 128이므로
    public static final int MAX_LENGTH = 128;
    public static boolean isUniqueChars_sol1(String str) {
        if (str.length() > MAX_LENGTH) {
            return false;
        }
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if (charSet[value]) {
                return false;
            }
            charSet[value] = true;
        }
        return true;
    }

    public static boolean isUniqueChars_sol2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';
            if ((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }

    // TIME: O(NlogN)
    // SPACE: O(N)
    public static boolean isUniqueChars_sol3(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(Array1.isUniqueChars_1("abcdefb"));
        System.out.println(Array1.isUniqueChars_2("abcdefb"));
    }
}
