package stackandqueue;

import java.util.Stack;

public class StackAndQueue5 {
    /**
     * 스택 정렬
     * 가장 작은 값이 위로 오도록 스택을 정럴하는 프로그램 작성해라
     * 추가적으로 하나의 스택은 사용해도 괜찮지만, 스택에 보관된 요소를 배열 등의 다른 자료구조로 복사할 수는 없다
     * push, pop, peek, isEmpty의 네가지 연산을 제공해야 한다.
     */

    // TIME: O(N^2)
    // Space : O(N) - 새로운 STACK 사용

    /**
     * 내풀이 : 새로운 STACK인 newStack을 사용한다.
     * 일단 value를 pop한거 하나 가지고
     * stack에서 peek한 값이랑 value를 비교해서 작은것이 newStack에 들어가게 한다.

     * 다 끝나면 newStack에 똑같이 pop한 value와 peek한 값을 비교해서 큰것부터 stack에 들어가게 한다.
     * -> 계속 반복한다 : value의 값이 계속 바뀔때까지
     * -> count로 stack.size 선언해서 0 이면 정렬이 완료되었으므로 탈출.
     */
    static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();


        while (true) {
            int value = stack.pop();
            int count = stack.size();

            // newstack에 붓기
            while (!stack.isEmpty()) {
                if (stack.peek() > value) {
                    newStack.push(value);
                    value = stack.pop();
                } else {
                    newStack.push(stack.pop());
                }
            }

            // 다시 stack에 붓기
            while (!newStack.isEmpty()) {
                if (newStack.peek() < value) {
                    stack.push(value);
                    value = newStack.pop();
                    count--;
                } else {
                    stack.push(newStack.pop());
                }
            }
            // value또한 stack에 넣어준다.
            stack.push(value);

            if (count == 0) {
                return stack;
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(7);
        integerStack.push(4);
        integerStack.push(9);
        integerStack.push(3);
        integerStack.push(2);
        integerStack.push(8);
        integerStack.push(14);
        integerStack.push(6);
        integerStack.push(1);
        Stack<Integer> sortedStack = sort(integerStack);

        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }

    }
}
