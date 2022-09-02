import java.util.Scanner;

// String의 equals, equalsIgnoreCase
class String8 {
    public String solution(String str) {
        str = str.replaceAll("[^a-zA-Z]", "");
//        str = str.replaceAll("^[a-zA-Z]*$", "");
        System.out.println(str);
        // 1.str에서 알파벳 빼고 다 제외시킨다.
        // 2. 똑같은 방법으로.


        String answer = str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "YES" : "NO";
        return answer;
    }

    public static void main(String[] args){
        String8 T = new String8();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(T.solution(str1));
    }
}