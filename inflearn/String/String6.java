import java.util.Scanner;

// 중복문자 제거
// indexOf() 제대로 쓰기. : 앞에서 처음 발견되는 문자 인덱스 반환.
class String6 {
    public String solution(String str) {
        // 들어오는게 이미 존재하면 skip
        String answer = "";
        for (char aChar : str.toCharArray()) {
            if (!answer.contains(""+aChar)) answer+=aChar;
        }
        return answer;
    }
    // 강사 풀이
    public String solution1(String str) {
        // 들어오는게 이미 존재하면 skip
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }


    public static void main(String[] args){
        String6 T = new String6();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));

    }
}