package engineerkorea;

/**
 * 주어진 문자열의 공백을 %20으로 변환하는 함수를 구현하세요
 * 문자열의 맨 끝에는 변환에 필요한 충분한 공백이 있고,
 * 실제 문자열의 사이즈를 알고 있음.
 */
public class StringUrlEncoding {
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith             ", 13));

    }

    // 공백을 %20으로 대체하면 2개의 추가 공간이 필요하다.
    // 따라서 13 + 공백수 * 2의 저장공간이 필요함.
    private static String URLify(String str, int len) {
        return URLify(str.toCharArray(), len);
    }

    private static String URLify(char[] str, int len) {
        int spaces = 0;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') spaces++;
        }
        int index = len + spaces * 2 - 1;
        for (int p = len - 1; p >= 0; p--) {
            if (str[p] == ' ') {
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            } else {
                str[index--] = str[p];
            }
        }
        return new String(str);
    }
//  내풀이
    private static String urlEncoding(String str) {
        str.replace(" ", "%20");
        return str;
    }
}
