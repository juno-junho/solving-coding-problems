public class CaesarCipher {
    // 다른 사람 풀이 보기
    static String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            if (chars[i] +n > 'Z' && chars[i] < 'a') {
                chars[i] += n -26;
                continue;
            }
            if (chars[i] + n > 'z' ) {
                chars[i] += n - 26;
                continue;
            }
            chars[i] += n;
        }

        String answer = new String(chars);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("wzqkf nsk",1));

    }
}
