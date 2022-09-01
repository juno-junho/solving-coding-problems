import java.util.Scanner;

class String5 {
    // 특정 문자 뒤집기
    public String solution(String str){
        // 1. select alphabet
        // 2. reverse alphabet
        // 3. insert reversed alpabet in origin position
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if ((aChar >= 'A' && aChar <= 'Z') || (aChar >= 'a' && aChar <= 'z')) sb.append(aChar);
        }
        sb.reverse();
        String s = str.replaceAll("[a-zA-Z]", "a");

        int index = 0;
        StringBuilder sb1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != 'a')  sb1.append(c);
            else sb1.append(sb.charAt(index++));
        }
        return sb1.toString();
    }

    public static void main(String[] args){
        String5 T = new String5();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));

    }

}