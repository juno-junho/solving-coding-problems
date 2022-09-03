import java.util.Scanner;

// String의 equals, equalsIgnoreCase
class String8 {
    public String solution(String str) {
        str = str.replaceAll("[^a-zA-Z]", "");
//        str = str.replaceAll("^[a-zA-Z]*$", "");
        String answer = str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "YES" : "NO";
        return answer;
    }
    // 강사 풀이
    public String solution1(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args){
        String8 T = new String8();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));
    }
}