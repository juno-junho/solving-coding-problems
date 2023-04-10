import java.util.*;

public class Q_4949_stack {
    /**
     * 균형 잡힌 세상.
     * 문자열에 포함되는 괄호는 () 와 [] 두 종류.
     * 소괄호는 소괄호와만 짝이루어야 한다.
     * 대괄호는 대괄호만 짝 이루어야 한다.
     * 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        while (true) {
            String input = sc.nextLine();

            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                if (letter == '(' || letter == '[') {
                    stack.push(letter);
                }
                if (letter == ']') {
                    if (stack.isEmpty()) {
                        System.out.println("no");
                        return;
                    }
                    if (stack.peek() != '[') {
                        System.out.println("no");
                        return;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
                if (letter == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("no");
                        return;
                    }
                    if (stack.peek() != '(') {
                        System.out.println("no");
                        return;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
}
