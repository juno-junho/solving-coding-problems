import java.util.Scanner;
import java.util.Stack;

class StackAndQueue2 {
    // 내풀이 : ( -> stack에 넣고 )로
    String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            if (x == ')') stack.pop();
            else if (stack.isEmpty()) sb.append(x);
        }

        return sb.toString();
    }
    // 강사풀이
    String solution1(String str) {
        // ( 와 알파벳은 무조건 push
        // ) 만나면 ( 만날때 까지 push
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack();
        for (char x : str.toCharArray()) {
            if (x == ')'){
                while (stack.pop() != '(');
            } else stack.push(x);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        StackAndQueue2 T = new StackAndQueue2();
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(T.solution1(string));
    }
}
