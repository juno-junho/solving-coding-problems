import java.util.Scanner;

class String12 {
    // 암호
    public String solution(int n, String str) {
        char[] words = new char[n];
        // 길이로 자르는것은 substring

        int j = 0;
        for (int i = 0; i <n; i++) {
            String s = str.substring(j, j + 7).replace("#", "1").replace("*", "0");
            j += 7;

            words[i] = (char) Integer.parseInt(s, 2);
        }
        return String.valueOf(words);
    }
    // 강사풀이
    public String solution1(int n, String str) {
        String answer = "";
        for (int i = 0; i <n; i++) {
            String s = str.substring(0,  7).replace("#", "1").replace("*", "0");
            answer+= (char) Integer.parseInt(s, 2);
            str = str.substring(7);
        }
        return answer;
    }
    public static void main(String[] args){
        String12 T = new String12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}