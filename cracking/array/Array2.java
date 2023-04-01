package array;

import java.util.Arrays;

public class Array2 {

    // TIME : O(NlogN)
    // SPACE : O(N)
    // 정답 풀이와 같음.
    private static boolean isPermutation_1(String s1, String s2) {
        // 길이 다르면 out
        if (s1.length() != s2.length()) {
            return false;
        }
        // 길이 같을때, 정렬하기
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        String newS1 = new String(charArr1);
        String newS2 = new String(charArr2);

        return newS1.equals(newS2);
    }

    // TIME : O(N)
    // SPACE : O(1)

    /**
     * 정답 풀이와 같음. 대신에 배열을 두개 쓸 필요 X 아래 메서드 참고.
     */
    private static boolean isPermutation_2(String s1, String s2) {
        // 길이 다르면 out
        if (s1.length() != s2.length()) {
            return false;
        }
        // array 시용
        int[] arr = new int[128];
        int[] arr2 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)]++;
            arr2[s2.charAt(i)]++;
        }
        return Arrays.equals(arr, arr2);
    }

    private static boolean isPermutation_sol2(String s1, String s2) {
        // 길이 다르면 out
        if (s1.length() != s2.length()) {
            return false;
        }

        int length = s1.length();
        // hash 사용
        int[] arr = new int[128];
        for (int i = 0; i < length; i++) {
            arr[s1.charAt(i)]++;
        }

        for (int i = 0; i < length; i++) {
            if (--arr[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
//        return Arrays.equals(arr, arr2);
    }
    public static void main(String[] args) {
    }
}
