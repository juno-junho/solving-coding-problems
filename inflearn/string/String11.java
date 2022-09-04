import java.util.Scanner;

class String11 {
    //문자열 압축
    public String solution(String str) {
        String answer = "";
        // count 변수 설정해두고 증가 -> 개수함께 answer에 넣기
        int count = 1;
        char target = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (target != str.charAt(i))  {
                answer += target;
                if (count != 1) answer += count;
                target = str.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
        }
        answer += target;
        if (count != 1) answer += count;

        return answer;
    }
    // 강사풀이 : i와 i+1 을 비교
    public String solution1(String str) {
        // 끝처리 : 마지막에 빈문자 하나 넣어주기
        String answer = "";
        str = str + ""; // 끝처리
        int count = 1;
        for (int i = 0; i < str.length() -1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) count++;
            else {
                answer += str.charAt(i);
                if (count != 1) answer += count;
                count = 1;
            }
        }
        // 끝처리
//        answer += str.charAt(str.length() - 1);
//        if (count != 1) answer+= count;

        return answer;
    }

    public static void main(String[] args){
        String11 T = new String11();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution1(str1));
    }
}