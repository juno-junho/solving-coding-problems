package stackandqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackAndQueue3 {
    /**
     * Set of stacks 구현하기.
     * 여러개의 stack으로 구성되어 있으며, 이전 스택이 지정된 용량 초과하는 경우 새로운 스택 생성
     * push()와 pop()은 스택이 하나인 경우와 동일하게 동작해야 한다.
     * pop()은 정확히 하나의 스택이 있을 때와 동일한 값을 반환해야 한다.
     * <p>
     * 내풀이 :
     * 지정 용량을 받는다.
     * 용량 초과하는 경우 새로운 스택 생성한다.
     * <p>
     * 답지 풀이)
     * 1. 마지막 스택을 가지고 온다.
     * 2. stack이 null이 아니고 가득 차 있는것 아닌지 확인한다.
     * 3. null이 아니고 가득차있지 않다면 그 stack에 푸쉬하고,
          아니면 새로운 스택을 만들어 푸쉬하고 list에 stack을 추가한다.
     * 4. pop의 경우도 마지막 스택 가지고 와서 null이면 exception 던지고,
     * -- 개념은 비슷.. 넘어가자.
     */
    static class SetOfStacks {
        private ArrayList<Stack<Integer>> stackList = new ArrayList<>();
        private int stackSize;  // stack의 max 크기
        private int currentSize = 0;    // 현재 스택의 크기
        private int currentStackIndex = 0; // 현재 스택의 index

        public SetOfStacks(int stackSize) {
            this.stackSize = stackSize;
        }

        public void push(int value) {
            Stack<Integer> currentStack = stackList.get(currentStackIndex);
            currentStack.push(value);
            currentSize++;

            createNewStackIfIsFull();
        }

        private void createNewStackIfIsFull() {
            if (currentSize == stackSize) {
                stackList.add(new Stack<>());
                currentStackIndex++;
                currentSize = 0;
            }
        }

        public int pop() {
            Stack<Integer> currentStack = stackList.get(currentStackIndex);
            int data ;
            try {
                data = currentStack.pop();
            } catch (EmptyStackException e) {
                currentStack = stackList.get(--currentStackIndex);
                data = currentStack.pop();
                currentSize = stackSize - 1;
                return data;
            }
            currentSize--;
            return data;
        }

        public int popAt(int index) {
            int quotient  = index / stackSize;
            int remainder = index % stackSize;

            Stack<Integer> stack = stackList.get(quotient);
            return stack.remove(remainder);
        }

    }

    private static class Node {
        private final int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
