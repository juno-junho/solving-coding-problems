import java.util.NoSuchElementException;

/**
 *
 * Queue 구현은 First와 Last 두 멤버 변수로 구현 가능하다. (FIFO 구조에서 그 First)
 * First가 가리키는 것은 가장 먼저 들어온 데이터,
 * Last가 가리키는 것은 가장 최근에 들어온 데이터를 말하며,
 * 처음 들어온 노드가 다음 들어온 노드를 next로 받는 구조로 구현 가능하다.
 */
public class QueueChapter<T> {

    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // 멤버 변수
    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> node = new Node<>(item);
        // 내풀이
        if (first == null) {
            first = node;
        }
        if (last != null) {
            last.next = node;
        }
        last = node;

        /*강사 풀이
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {    // 데이터가 없을 때
            first = last;
        }*/
    }

    public T remove() {
/*
        if (first == null) {    // queue가 비어 있으면
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
*/

        // 없으면 던지기
        if (first == null) {
            throw new NoSuchElementException();
        }
        // 있으면
        T data = first.data;
        first = first.next;
        if (first == null) {    // element가 하나일때, 모두 삭제
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
        QueueChapter<Integer> queue = new QueueChapter<>();
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
