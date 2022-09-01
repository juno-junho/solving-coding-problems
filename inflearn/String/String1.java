import java.util.Scanner;

class String1 {
    public int solution(String str, char t){
        int answer = 0;
        for (char c : str.toUpperCase().toCharArray()) {
            if (t == c) answer++;
        }
        return answer;
    }
    public static void main(String[] args){
        String1 T = new String1();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        char char1 = sc.next().toUpperCase().charAt(0);
        System.out.println(T.solution(str1,char1));

    }

}