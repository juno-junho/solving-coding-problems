package engineerkorea;

/**
 * you have isSubString() which checks if one word is a substring of another
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString()
 * -> isSubstring() 함수를 단 한번만 사용해서
 * 회전된 문자열 이란 말은 string => trings => ringst => ingstr ...
 * 오른쪽의 문자열이 왼쪽의 문자열을 회전시킨 함수인지를 isSubstring 단 한번만 써서.  확인.
 *
 */
// 음..
class StringIsSubString {
    public static void main(String[] args) {
        System.out.println(isRotation("string", "ringst"));
        System.out.println(isRotation("string", "ingstr"));
        System.out.println(isRotation("string", "ingstn"));
        System.out.println(isRotation("string", "ringstr"));
    }


/*    // 내풀이
    // 일단 문자의 길이가 같은지 확인
    // for문 돌면서 s1과 같은게 나오고, 일치하면서 끝에 도착했을때, 남은 s1의 부분의 문자열이 s2의 substring인지 확인하면됨.
    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != s1.charAt(j)) sb.append(s2.charAt(i));
            else j++;
        }
        return isSubString(s1, sb.toString());
    }

    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }*/

    // idea는 s2 string을 2개를 붙힌다음 s1이 있는지 확인하면 됨.
    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return isSubString(s1 + s1, s2);

    }

    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }
}
