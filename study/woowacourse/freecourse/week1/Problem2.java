package freecourse.week1;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack();

        char popped = ' ';
        for (char letter : cryptogram.toCharArray()) {
            if (letter == popped) continue;
            if (!stack.isEmpty() && stack.peek() == letter) {
                popped = stack.pop();
                continue;
            }
            stack.push(letter);
        }
        StringBuilder stringBuilder = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(Problem2.solution("zyellleyz"));

    }

}
