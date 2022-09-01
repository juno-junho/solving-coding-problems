import java.util.Scanner;

class String4 {
    public String[] solution(String[] arr){
        String[] answer = new String[arr.length];
        StringBuilder sb;
        for (int i = 0; i < arr.length; i++) {
            sb = new StringBuilder(arr[i]);
            answer[i] = sb.reverse().toString();
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

        for (String s : T.solution(arr)) {
            System.out.println(s);
        }
    }
}