package array;

public class Array6 {

    /**
     * 문자열 압축
     * aabccccaaa -> a2b1c5a3
     * 압축된 문자열 길이가 기존 문자열 보다 길다면 기존 문자열 반환.
     * 문자열은 대소문자 알파벳으로만 이루어져 있다.

     * 내 풀이: Stringbuilder 사용해서 이전 문자와 비교해서 같으면 count ++, 다르면 sb에 붙히기
     * 풀이와 정답 일치.
     *  -> 이게 최선인가?
     *  길이 먼저 확인해 볼 수 있으면 반복되는 문자가 그리 많지 않는 경우 속도 더 줄일 수 있다.
     *
     */

    // TIME : O(N)
    // SPACE : O(N)
    static String compress1(String str) {
        StringBuilder sb = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (currentChar == str.charAt(i)) {
                count++;
            }else {
                sb.append(currentChar).append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        sb.append(currentChar).append(count);
        return str.length() > sb.length() ? sb.toString() : str;
    }

    static String compress_sol1(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    // TIME : O(N)
    // SPACE : O(1)
    static String compress_sol2(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    // TIME : O(N) / SPACE : O(1)
    private static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    public static void main(String[] args) {
        System.out.println(Array6.compress1("aabccccaaa"));
    }
}
