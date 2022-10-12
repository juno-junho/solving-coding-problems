package engineerkorea;

import java.util.Arrays;

class StringPermutation {
    /**
     * 주어진 두 개의 문자열이 서로 치환되는지를 알아내는 함수를 구현하세요
     * ---------------------------------------------------------
     * 치환이란 어떤 문자열 안의 문자의 순서를 바꾼것을 치환이라고 한다.
     * -> 두 문자열이 치환이 되려면 가지고 있는 문자의 종류와 개수가 같아야 한다.
     * 이 질문을 받으면 치환의 조건이 대소문자 구별하는지, 공백은 무시하는지 확인해야 한다.
     * 여기서는 공백도 문자로 인정, 대소문자 구별
     */
    public static void main(String[] args) {
        permutation("ABC", "BCA");
        permutation("ABC", "BDA");

    }
    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    private static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    private static boolean permutationUsingAscii(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            letters[value]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int value = t.charAt(i);
            letters[value]--;
            if (letters[value] < 0) return false;
        }
        return true;
    }
}

