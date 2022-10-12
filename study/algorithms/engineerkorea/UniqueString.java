package engineerkorea;

import java.util.Arrays;
import java.util.HashMap;

class UniqueString {
    /**
     * 주어진 문자열의 문자들이 모두 고유한지 확인하는 함수를 구현하시오
     * 만약 별도의 저장공간을 사용하지 못하는 경우에는 어떻게 해결할지도 추가적으로 설명하시오
     * -> 아스키코드인지 유니코드인지 구분해야한다.
     */
    public static void main(String[] args) {
        System.out.println(isUniqueNotUsingDataStructure("abczwedfgghik"));
        System.out.println(isUniqueNotUsingDataStructure("abczywedfghik"));
    }

    private static boolean isUnique(String str) {
        if (str.length() > 128) return false;
        boolean[] ascii = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (ascii[str.charAt(i)]) return false;
            ascii[str.charAt(i)] = true;
        }
        return true;
    }
    private static boolean isUniqueUnicode(String str) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if(hashMap.containsKey(value)) return false;
            hashMap.put(value, true);
        }
        return true;
    }
    // a를 0, z를 25로 해서 있으면 스위치를 올려주듯 그 해당 자리에 1로 설정.
    private static boolean isUniqueUsingBitOperation(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;   // checker와 and 연산해서 0보다 크다는 말은 이미 1인곳에 중복해서 1이 있다는 것.
            checker |= (1 << val);  // checker에 스위치 위치 합쳐주기.
        }
        return true;
    }

    private static boolean isUniqueNotUsingDataStructure(String str) {
        // O(n^2)
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) return false;
            }
        }
        // O(nlogn) quick sort -> for문 돌기
/*        quickSort(str);
        for (i  nt i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) return false;
        }*/
        return true;
    }
}
