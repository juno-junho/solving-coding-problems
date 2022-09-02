import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
// char 배열을 string으로 변환하는것 : new String(chars) or String.valueOf(chars)
class String4 {
    public String[] solution1(String[] arr){
        String[] answer = new String[arr.length];
        StringBuilder sb;
        for (int i = 0; i < arr.length; i++) {
            sb = new StringBuilder(arr[i]);
            answer[i] = sb.reverse().toString();
        }
        return answer;
    }
    public ArrayList<String> solution(int n, String[] arr){
        ArrayList<String> answer = new ArrayList<>();

        for (String s : arr) {
            String temp = new StringBuilder(s).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }
    // StringBuilder 사용하지 않고 뒤집기.
    public ArrayList<String> solution2(int n, String[] arr){
        ArrayList<String> answer = new ArrayList<>();

        for (String s : arr) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
//            answer.add(chars.toString());
            answer.add(String.valueOf(chars));
        }
        return answer;
    }
    public ArrayList<String> solution3(int n, String[] arr){
        ArrayList<String> answer = new ArrayList<>();

        for (String s : arr) {
            char[] chars = s.toCharArray();
            int lt = 0, rt =s.length() - 1;
            while (lt < rt){
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++; rt--;
            }
            answer.add(String.valueOf(chars));
        }
        return answer;
    }

    public static void main(String[] args){
        String4 T = new String4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (String s : T.solution(n, arr)) {
            System.out.println(s);
        }
    }
}