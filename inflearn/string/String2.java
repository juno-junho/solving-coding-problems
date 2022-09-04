import java.util.Scanner;

class String2 {
    public String solution(String str){
        // str에 대문자는 소문자로, 소문자는 대문자로

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
            else if (chars[i] >= 'a' && chars[i] <= 'z') chars[i] -= 32;
        }
//        String answer = "";
//        for (char c : str.toCharArray()) {
//            if (Character.isLowerCase(c)) answer += Character.toUpperCase(c);
//            else answer += Character.toLowerCase(c);
//        }

        return new String(chars);
//        return answer;
    }

    public static void main(String[] args){
        String2 T = new String2();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        System.out.println(T.solution(str1));

    }

}