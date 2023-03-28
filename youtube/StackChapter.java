import java.util.EmptyStackException;

/**
 * Stack은 가장 위에 있는 Node인 top만 알고 있으면 된다.
 * 그리고 top의 next 주소로 아래 노드를 가리키고 있으면 된다.
 */
public class StackChapter<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // 멤버 변수
    private Node<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

     public boolean isEmpty() {
         return top == null;
     }

    public static void main(String[] args) {
        StackChapter<Integer> s = new StackChapter<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
