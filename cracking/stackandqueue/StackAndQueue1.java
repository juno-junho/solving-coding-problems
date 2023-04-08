package stackandqueue;

import java.util.EmptyStackException;

public class StackAndQueue1 {
    /**
     * 배열 하나로 stack 3개를 구현해라.
     *
     * 내가 생각한 방법 :
     * stack의 max length를 설정할 수 있어야 한다.
     * 그리고 array의 길이를 stack의 max length * 3으로 만든다
     * ptr1, ptr2, ptr3를 지정한다 (stack의 top을 가리키는)
     * 그래서 stack max_length = k라 할때, ptr1 = 0, ptr2 = k, ptr3 = 2k로 설정해서,
     * 각 stack의 ptr를 이용해서 배열에 값을 push, remove, peek한다.

     * 답지 풀이 : ptr를 배열을 사용해서 size를 잡음.
     * 그래서 indexOfTop() method에서 size와 stack의 max size를 통해서 values의 값이 있는 위치 계산함.
     */

    public static class FullStackException extends RuntimeException {
        public FullStackException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class ThreeStackArray {
        private final int numStack = 3;
        private int stackSize;
        private int[] values;   // 3개의 stack의 값을 저장.
        private int[] sizes;    // 각 stack의 value 수를 추적하기 위해서

        public ThreeStackArray(int stackSize) { // stack의 크기를 설정한다 (max_size)
            this.stackSize = stackSize;
            this.values = new int[stackSize * numStack];    // 내가 말한 그 하나의 배열 생성
            this.sizes = new int[numStack]; //3개의 배열 생성
        }

        public void push(int stackNum, int value) {
            if (stackNum == 1 || stackNum == 2 || stackNum == 3) {
                throw new IllegalArgumentException();
            }
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            if (isFull(stackNum)) {
                throw new FullStackException("This stack is full");
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum) {
            if (stackNum == 1 || stackNum == 2 || stackNum == 3) {
                throw new IllegalArgumentException();
            }
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            int valueToRemove = values[indexOfTop(stackNum)];
            sizes[stackNum]--;
            return valueToRemove;
        }

        public int peek(int stackNum) {
            if (stackNum == 1 || stackNum == 2 || stackNum == 3) {
                throw new IllegalArgumentException();
            }
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            return values[indexOfTop(stackNum)];
        }

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackSize;
            int size = sizes[stackNum];
            return offset + size - 1;
        }


        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        private boolean isFull(int stackNum) {
            return sizes[stackNum] == stackSize;
        }
    }
}
