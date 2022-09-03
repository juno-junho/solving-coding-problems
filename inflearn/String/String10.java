import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class String10 {
    // 가장 짧은 문자거리
    public int[] solution(String str, char t) {
        // indexOf 사용 불가 -> str에서 t의 위치를 저장한다.
        // 위치를 str.length-1까지 for돌면서 값 최대한 작은것 배열에 담아 출력
        // O(n^2) 최대
        int[] answer = new int[str.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t) list.add(i);
        }
        for (int i = 0; i < str.length(); i++) {
            int[] num = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                num[j] = Math.abs(i - list.get(j));
            }
            int min = num[0];
            for (int k = 0; k < num.length; k++) {
                if (min > num[k]) min = num[k];
            }
            answer[i] = min;
        }
        return answer;
    }
    // 강사 풀이 O(n)
    public int[] solution1(String str, char t) {
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            }
            else {
                p++;
                answer[i] = p;
            }
        }
        // 오른쪽 부터
         p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == t) p = 0;
            else {
                p++;
                answer[i] = Math.min(p, answer[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String10 T = new String10();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        char t = sc.next().charAt(0);
        for (int x : T.solution(str1, t)) {
            System.out.print(x + " ");
        }
    }
}