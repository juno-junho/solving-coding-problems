package stackandqueue;

import java.util.NoSuchElementException;

public class QueueImpl<T> {
    class Node {
        private final T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    // 멤버 변수
    private Node first;
    private Node last;

    public void add(T item) {
        Node node = new Node(item);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {    // 데이터가 없을 때
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;
        if (first == null) { // element가 하나일때, 삭제하면 last도 null로 맞춰줘야함.
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}
