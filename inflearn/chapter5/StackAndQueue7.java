import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackAndQueue7 {

    String solution(String need, String plan) {
        // classes를 돌면서 mandatory에 해당하는 것과 같은것이 있으면, queue에 offer.
        // 내 풀이는 틀린 풀이. C B B A면 yes 반환해야함.
        String s = "";
        for (char x : plan.toCharArray()) {
            for (char y : need.toCharArray()) {
                if (x == y) s += x;
            }
        }
        if (need.equals(s)) return "YES";
        else return "NO";
    }
    String solution1(String need, String plan) {
        // queue에 필수과목 넣어두고 시간표 하나씩 문자 돌면서 queue에 있으면 poll해서 없애기
        // queue가 비어있으면  return "YES"
        // C A B A 라 되어있으면? -> 해결됨.
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : need.toCharArray()) queue.offer(x);
        for (char x : plan.toCharArray()) {
            if (queue.contains(x)) {
                if (x!=queue.poll()) return "NO";
            }
        }
        if (!queue.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        StackAndQueue7 T = new StackAndQueue7();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1, s2));

    }
}
