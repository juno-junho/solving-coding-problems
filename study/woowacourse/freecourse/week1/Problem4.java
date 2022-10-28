package freecourse.week1;

public class Problem4 {
    public static String solution(String word) {

        StringBuilder sb = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) {
            sb.append(convertWithDictionary(letter));
        }
        return sb.toString();
    }
    static char convertWithDictionary(char letter) {
        if (Character.isUpperCase(letter)) {
            return (char) ('Z' - (letter - 'A'));
        }
        if (Character.isLowerCase(letter)) {
            return (char) ('z' - (letter - 'a'));
        }
        return letter;
    }

    public static void main(String[] args) {
        System.out.println(Problem4.solution("123I love you"));
    }
}