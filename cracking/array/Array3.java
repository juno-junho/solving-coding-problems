package array;

public class Array3 {

    /**
     * urlify
     * 문자열의 모든 공백을 %20으로 치환
     * 모든 문자 다 담을수 있는 충분한 공간 확보 && 문자열 최종길이 함께 주어진다 가정.
     * char array 사용하기
     */
    // 시간복잡도 : 모르겠음.. 공간 복잡도 또한 모르겠다.
    private static String urlify(String str, int length) {
//        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < length; i++) {
            if (stringBuilder.charAt(i) == ' ') {
                stringBuilder.replace(i, i+1, "%20");
            }
        }
        return stringBuilder.toString();
    }
    private static String urlify_2(String str, int length) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                replaceBlank(chars, i);
            }
        }
        return new String(chars);
    }

    private static void replaceBlank(char[] chars, int i) {
        // i index를 %20으로 대체
        // -> StringBuilder 구현으로 대체..
//        chars.length-1
    }

    // TIME : O(N)
    // SPACE : O(1)
    private static void replaceSpaces_sol1(char[] str, int length) {
        int spaceCount = 0;
        int index, i = 0;
        // 공백 개수 count
        if (str[i] == ' ') {
            spaceCount++;
        }

        index = length + spaceCount * 2;
        if (length < str.length) {
            str[length] = '\0'; // 배열의 끝
        }
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[--index] = str[i];
            }
        }
    }


    public static void main(String[] args) {

        System.out.println(Array3.urlify("Mr John Smith", 13));

    }
}
