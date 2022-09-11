import java.util.Scanner;
import java.util.Stack;

class StackAndQueue1 {
    // stack은 운동장에 구덩이라 생각하면된다.ㄹ
    String solution(String str) {
        String answer = "NO";

        Stack<Character> stack = new Stack();
        try {
            for (char x : str.toCharArray()) {
                if (x != '(' && x != ')') throw new RuntimeException();
                if (x == ')') stack.pop();
                else stack.push(x);
            }
        } catch (RuntimeException e) {
            return answer;
        }
        if (stack.isEmpty()) return "YES";
        return answer;
    }

    // 강사 풀이
    String solution1(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        StackAndQueue1 T = new StackAndQueue1();
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(T.solution(string));
    }
}
