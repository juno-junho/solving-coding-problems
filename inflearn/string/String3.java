import java.util.Scanner;

class String3 {
    public String solution(String str){
        String answer = "";

        // 방법 1
//        String[] s = str.split(" ");
//
//        for (String s1 : s) {
//            if (s1.length() > answer.length()) answer = s1;
//        }
        // 방법 2. indexOf, subString 으로 풀어보기

        return answer;
    }

    public static void main(String[] args){
        String3 T = new String3();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));

    }

}