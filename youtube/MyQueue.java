import java.util.Stack;

/**
 * 두 개의 stack으로 하나의 queue를 만드는 방법
 *  -> stackOldest, stackNewest를 활용한 방법.
 */
class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    public void shiftStacks() {
        // oldest가 비어있을때만 실행해야 data가 이상해 지지 않는다.
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
