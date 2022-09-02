import java.util.Scanner;
// 특정 문자 뒤집기
class String5 {
    // 공부할것 ) toString()과 String.valueOf() 차이 (String.valueOf()가 더 빠름) ..이유도 생각해보기
    // Character 클래스의 메소드들.   

    public String solution(String str){
        // 1. select alphabet
        // 2. reverse alphabet
        // 3. insert reversed alpabet in origin position
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
//            if ((aChar >= 'A' && aChar <= 'Z') || (aChar >= 'a' && aChar <= 'z')) sb.append(aChar);
            if (Character.isAlphabetic(aChar)) sb.append(aChar);
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
    // 강의 풀이
    public String solution1(String str){

        char[] chars = str.toCharArray();
        int lt = 0, rt =str.length() - 1;

        while (lt < rt){
            //
            if (!Character.isAlphabetic(chars[lt])) lt++;
            else if (!Character.isAlphabetic(chars[rt])) rt--;
            else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++; rt--;
            }
        }
//        return new String(chars);
        return String.valueOf(chars);
    }


    public static void main(String[] args){
        String5 T = new String5();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));

    }

}