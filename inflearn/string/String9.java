import java.util.Scanner;

class String9 {
    public int solution(String str) {
        // str에서 숫자빼고 제거
        str = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(str);
    }
    // 강사풀이
    public int solution1(String str) {
        // char 배열로 만들어 아스키코드 48이상 57 이하이면 anwer에 answer = answer * 10 +(x-48) 해주기
//        int answer = 0;
        String answer = "";

        for (char x : str.toCharArray()) {
//            if (x >= 48 && x <= 57) answer = answer * 10 + (x - 48);
            if (Character.isDigit(x)) answer +=x;
        }

//        return answer;
        return Integer.parseInt(answer);

    }

    public static void main(String[] args){
        String9 T = new String9();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));
    }
}