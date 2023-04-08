package stackandqueue;

import java.util.Stack;

public class StackAndQueue4<T> {
    /**
     * 스택 두개로 하나의 queue를 만들어라
     *
     * 내풀이 )
     * 근데 단점이 add 하고 난 후 peek, remove 호출 할 수 있지만, 그 이후 add가 안된다.
     */

    private final Stack<T> newStack;
    private final Stack<T> oldStack;

    public StackAndQueue4() {
        this.newStack = new Stack<>();
        this.oldStack = new Stack<>();
    }

    public int size() {
        return newStack.size() + oldStack.size();
    }
    public void add(T value) {
        newStack.push(value);
    }
    public T peek() {
        shiftStacks();
        return oldStack.peek();
    }
    public T remove() {
        shiftStacks();
        return oldStack.pop();
    }

    public void shiftStacks() {
        // old가 있을 경우 붓기
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }
    }
    public static void main(String[] args) {
        StackAndQueue4<Integer> queue = new StackAndQueue4<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(4);
        queue.add(5);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

}
