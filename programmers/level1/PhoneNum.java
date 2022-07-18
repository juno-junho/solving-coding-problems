public class PhoneNum {
    // 정규식 공부하고 풀이 참고하기.
    static String solution(String phone_number) {
        // 마지막 4자리 배고 "*"로 바꾸기 -> string.length() - 4 로 charArray 바꾸기
        char[] chars = phone_number.toCharArray();
        for (int i = 0; i < chars.length - 4; i++) {
            chars[i] = '*';
        }
        return new String(chars);
    }
    static String solution2(String phone_number) {
        // 정규식 사용
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
    public static void main(String[] args) {

    }
}
