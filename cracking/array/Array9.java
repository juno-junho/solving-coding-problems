package array;

public class Array9 {


    /**
     * s1과 s2의 두 문자열이 주어졌고, s2가 s1을 회전시킨 결과인지 판별하고자 한다.
     * waterbottle -> erbottlewat
     * <p>
     * isSubstring 한번만 호출해서 판별할 수 있는 코드 작성해라.
     * <p>
     * 내 풀이 : s2를 두개 붙혀서 s1을 포함하는지 확인하면 된다.
     *  -> 정답과 일치.
     *
     */

    // TIME : O(N^2)
    // SAPCE: O(1)
    static boolean isSubstring(String word, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + 1; j < s2.length(); j++) {
/*                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println(s2.substring(i, j));*/
                if (s2.substring(i, j).equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String concateString = s2 + s2;
        return isSubstring(s1, concateString);
    }

    static boolean isRotation_sol(String s1, String s2) {
        int length = s1.length();
        if (length == s2.length() && length > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Array9.isRotation("wwwawwbw", "wbwwawww"));

    }
}
