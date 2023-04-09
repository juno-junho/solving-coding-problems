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
     * <p>
     * 다 끝나면 newStack에 똑같이 pop한 value와 peek한 값을 비교해서 큰것부터 stack에 들어가게 한다.
     * -> 계속 반복한다 : value의 값이 계속 바뀔때까지
     * -> count로 stack.size 선언해서 0 이면 정렬이 완료되었으므로 탈출.
     */
    static void sort(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        int valueChanged = 0;
        while (true) {
            int value = stack.pop();
            valueChanged++;
            int count = stack.size();

            // newstack에 붓기
            while (!stack.isEmpty()) {
                if (stack.peek() > value) {
                    newStack.push(value);
                    value = stack.pop();
                    valueChanged++;
                } else {
                    newStack.push(stack.pop());
                }
            }

            // 다시 stack에 붓기
            while (!newStack.isEmpty()) {
                if (newStack.peek() < value) {
                    stack.push(value);
                    value = newStack.pop();
                    valueChanged++;
                    count--;
                } else {
                    stack.push(newStack.pop());
                }
            }
            // value또한 stack에 넣어준다.
            stack.push(value);

            if (count == 0) {
                System.out.println("valueChanged = " + valueChanged);
                return;
            }
        }
    }

    /**
     * 답지 풀이:
     * 기존 stack에서 pop하면서 새로운 stack s2의 데이터와 비교하면서
     * 자기보다 큰 data를 s1으로 옮기는 것이다.
     * 가장 작은게 s2의 가장 밑에 오도록.
     *
     * 내풀이와 비교해서 개념은 비슷...
     * 시간/공간 복잡도도 같지만
     * 내풀이는 계속 붓고 붓고 붓고 ..
     * 사실 비슷하긴 할것 같은데 굳이 따지자면 내 풀이가 값 변경이 더 많이 되긴 할듯.
     */
    // TIME: O(N^2)
    // Space : O(N) - 새로운 STACK 사용
    static void sort_sol(Stack<Integer> s1) {
        int valueChanged = 0;
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int tmp = s1.pop();
            valueChanged++;
            while (!s2.isEmpty() && s2.peek() > tmp) {  // 비어있거나 s2.peek이 tmp보다 작거나 같으면 안돈다.
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }

        //s1에 붓기
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        System.out.println("valueChanged = " + valueChanged);
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

        long start = System.nanoTime();
//        Stack<Integer> sortedStack = sort(integerStack);
        sort_sol(integerStack);

        long end = System.nanoTime();
        System.out.println("time spent to sort stack : " + ((end - start) / 1000));

/*        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }*/

        while (!integerStack.isEmpty()) {
            System.out.println(integerStack.pop());
        }
    }
}
