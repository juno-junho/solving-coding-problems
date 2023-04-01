package array;

public class Array5 {

    /**
     * 문자열 편집하는 방법 세 가지 종류
     * 1. 문자 삽입
     * 2. 문자 삭제
     * 3. 문자 교체
     * * 문자열 두 개 주어졌을때 문자열 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수.
     */

    /**
     * 1. 길이 같은지 확인
     * -> 다르다? 하나가 다른 하나에 포함되는지 확인
     * 2. 길이 같다 -> 하나씩 돌면서 letter 다른지 확인.
     * 3. 다른것 하나다 ? true : false
     */
    private static boolean isWithinOneEditing(String str1, String str2) {
        int length = Math.max(str1.length(), str2.length());
        boolean isLengthGapMoreThanOne = Math.abs(str1.length() - str2.length()) != 1;
        // 길이 같으면
        if (str1.length() != str2.length()) {
            if (isLengthGapMoreThanOne) {
                return false;
            }
            int[] alphabet = new int[26];
            for (int i = 0; i < str1.length(); i++) {
                alphabet[str1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < str2.length(); i++) {
                alphabet[str2.charAt(i) - 'a']--;
            }
            int count = 0;
            for (int letter : alphabet) {
                if (letter == 1) {
                    count++;
                }
                if (letter == -1) {
                    count++;
                }
            }
            return (count <= 1);
        }
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Array5.isWithinOneEditing("pale", "ple"));
        System.out.println(Array5.isWithinOneEditing("pales", "pale"));
        System.out.println(Array5.isWithinOneEditing("pale", "bale"));
        System.out.println(Array5.isWithinOneEditing("pale", "bake"));

    }
}
