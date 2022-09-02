import java.util.Locale;
import java.util.Scanner;

// String의 equals, equalsIgnoreCase
class String7 {
    public String solution(String str) {
        String str1 = str.toLowerCase();
        String answer = str1.equals(new StringBuilder(str1).reverse().toString()) ? "YES" : "NO";
        return answer;
    }
    // 강사 풀이
    public String solution1(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return "NO";
        }
        return answer;
    }
    public String solution2(String str) {

        String answer = str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "YES" : "NO";
        return answer;
    }

    public static void main(String[] args){
        String7 T = new String7();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));
    }
}