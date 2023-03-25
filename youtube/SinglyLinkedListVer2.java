import java.util.HashMap;
import java.util.Map;

class SinglyLinkedListVer2 {
    /**
     * header를 하나의 빈 노드로 만든다.
     * -> 첫 노드 조작 가능
     */
    Node header;

    static class Node{
        int data;
        Node next = null;
    }

    public SinglyLinkedListVer2() {
        this.header = new Node();
    }

    void append(int data) {
        Node end = new Node();
        end.data = data;
        Node head = header;
        while (head.next != null) {
            head = head.next;
        }
        head.next = end;
    }

    void remove(int data) {
        Node head = header;
        while (head.next != null) {
            if (head.next.data == data) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
    }

    void print() {
        // header 다음 부터 출력
        Node head = header.next;
        while (head.next != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println(head.data);
    }

    /**
     * LinkedList에서 중복된 값 제거
     *
     * TIME : O(N^2)
     * SPACE : O(1)
     */
    void removeDups() {
        Node n = header;
        while (n != null && n.next != null) { // 마지막 노드 까지 돈다.
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
//                    remove(r.next.data);
                    r.next = r.next.next;
                } else {
                    r = r.next; // 다음 노드 주소값을 복사하는 것.
                }
            }
            n = n.next;
        }
    }

    /**
     * LinkedList에서 중복된 값 제거 - Buffer 이용
     * <p>
     * TIME : O(N)
     * SPACE : O(N)
     */
    void removeDupsUsingBuffer() {
        Map<Integer, Boolean> buffer = new HashMap<>();
        Node n = header;
        while (n.next != null) {
            if (buffer.getOrDefault(n.next.data, false)) {
                n.next = n.next.next;
                continue;
            }
            buffer.put(n.next.data, true);
            n = n.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedListVer2 ll = new SinglyLinkedListVer2();

        ll.append(2);
 /*       ll.append(3);
        ll.append(2);
        ll.append(5);
        ll.append(3);*/
        ll.append(2);
        ll.print();

        // Success
//        ll.remove(1);
        ll.removeDupsUsingBuffer();
        ll.print();
    }
}
