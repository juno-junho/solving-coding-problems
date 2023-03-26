import java.util.HashMap;
import java.util.Map;

class SinglyLinkedListVer2 {
    /**
     * header를 하나의 빈 노드로 만든다.
     * -> 첫 노드 조작 가능
     */
    Node header;

    static class Node {
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
     * <p>
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

    /**
     * 단방향 LinkedList에서 끝에서 K 번째 노드를 찾는 알고리즘을 구현하여라
     * 방법 1. index로
     */
    private static Node kthToLast(Node first, int k) {
        Node n = first;
        int total = 1;
        while (n.next != null) {
            total++;
            n = n.next;
        }
        n = first;
        for (int i = 1; i < total - k + 1; i++) {
            assert n != null;
            n = n.next;
        }
        return n;
    }

    /**
     * 단방향 LinkedList에서 끝에서 K 번째 노드를 찾는 알고리즘을 구현하여라
     * 방법 2. 재귀 호출
     * TIME : O(N) (linkedlist 길이 n)
     * SPACE : O(N)
     */
    private static int kthToLast_2(Node n, int k) {
        if (n == null) {
            return 0;
        }
        int count = kthToLast_2(n.next, k) + 1;
        if (count == k) {
            System.out.println("Last k(" + k + ") th data is " + n.data);
        }
        return count;
    }

    /**
     * 자바는 pass by reference가 없다.
     * count라는 변수의 주소를 전달 할 수 있으면 다음 함수 호출하고 count 값 받지 않아도 값이 어떻게 변했나 보면 된다.
     * 함수는 찾아낸 node만 반환하면 된다.
     *
     * 객체 / 배열은 stack에 pointer만 저장하기에 그것을 이용하는것.
     * count를 객체 안에 넣어 객체 주소를 전달하면 된다.
     */

    static class Reference{
        public int count = 0;
    }
    private static Node kthToLast_3(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }
        Node foundNode = kthToLast_3(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return foundNode;
    }

    /**
     * 단방향 LinkedList에서 끝에서 K 번째 노드를 찾는 알고리즘을 구현하여라
     * 방법 3. 포인터
     * TIME : O(N)
     * SPACE : O(1) - 별도의 버퍼 사용 X
     */
    private static Node kthToLast_4(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {   // 값이 없다.
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        SinglyLinkedListVer2 ll = new SinglyLinkedListVer2();

        ll.append(2);
        ll.append(3);
        ll.append(2);
        ll.append(5);
        ll.append(3);
        ll.append(2);
        ll.print();

        // Success
//        ll.remove(1);
//        ll.removeDupsUsingBuffer();
        int k = 5;
        Reference reference = new Reference();
        Node found = kthToLast_3(ll.header, k, reference);
        System.out.println(found.data);
        ll.print();
    }
}
