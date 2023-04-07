package linkedlist;


import linkedlist.LinkedList7.Node;

public class LinkedList4 {
    /**
     * 값 x가 주어졌을 때, x보다 작은 노드들을 x 보다 크거나 같은 노드들 보다 앞으로 오도록 코드 작성하기.
     * x가 리스트에 있다면 x는 그보다 작은 원소들보다 뒤에 나오기만 하면 된다.
     * -> 정답과 내풀이 idea 일치
     */

    public static void main(String[] args) {

        // Create
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(8);
        Node node4 = new Node(5);
        Node node5 = new Node(10);
        Node node6 = new Node(2);
        Node node7 = new Node(1);

        // Link
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node partition = partition_sol(node1, 5);
        while (partition.next != null) {
            System.out.print(partition.data + " -> ");
            partition = partition.next;
        }
        System.out.println(partition.data);

    }

    /**
     * 풀어본 문제라 기억이 난다.
     * <p>
     * 두 개의 포인터 사용
     * 그냥 노드 두개 만들어 돌리기
     */
    // TIME : O(N)
    // SPACE : O(1)
    static Node partition(Node head, int x) {
        Node left = new Node(0);
        Node pointer1 = left;

        Node right = new Node(0);
        Node pointer2 = right;

        while (head != null) {
            Node node = new Node(head.data);
            if (head.data < x) {
                left.next = node;
                left = left.next;
            } else {
                right.next = node;
                right = right.next;
            }
            head = head.next;
        }
        // 붙히기
        left.next = pointer2.next;
        return pointer1.next;
    }

    /**
     * 답지의 두번째 해설
     * 1. 두개의 head, tail 포인터를 만든다.
     * 2. list를 loop 돌면서 x와 비교해 작으면 앞에 붙히고, head를 앞으로 이동시킨다.
     * - x와 비교해 같거나 크면 뒤에 붙히고, tail을 뒤로 이동시킨다.
     * 3. head를 반환한다.
     */
    // TIME : O(N)
    // SPACE : O(1)
    static Node partition_sol(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            }else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    /**
     * 답지 풀이
     * 원소 이동 시킬때에는 원소의 값을 shift -> swap 하는 대신
     * 다른 연결리스트 두개 만든다.
     * 1. linkedList 돌면서 before 리스트 or after 리스트에 원소 삽입
     * 2. before와 after 합치면 된다.
     *
     */

    // TIME : O(N)
    // SPACE : O(1)
    static Node partition_sol2(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while (node != null) {
            Node next = node.next;
            node.next = null; // 따로 떼어 낸다.
            if (node.data < x) {    // 작으면 before 끝에 삽입
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                // after 끝에 원소 삽입
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        // 왼쪽 list가 없으면 그냥 오른쪽 리스트 반환
        if (beforeStart == null) {
            return afterStart;
        }
        // before / after 붙히기
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
