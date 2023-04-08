package stackandqueue;

import java.util.EmptyStackException;

/**
 * Stack은 가장 위에 있는 Node인 top만 알고 있으면 된다.
 * 그리고 top의 next 주소로 아래 노드를 가리키고 있으면 된다.
 */
public class StackImpl<T> {
    class Node {
        private final T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    // 멤버 변수
    private Node top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node node = new Node(item);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public int min() {
        // 솔직히 그냥 LinkedList head 주고 최솟값 찾으란거랑 똑같음..
        // TIME COMPLEXITY : O(N)
        Node runner = top;
        int min = (int) top.data;
        while (runner != null) {
            min = Math.min((Integer) runner.data, min);
            runner = runner.next;
        }
        return min;
    }
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackImpl<Integer> s = new StackImpl<>();
        s.push(-1);
        s.push(88);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("Min value = " + s.min());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
