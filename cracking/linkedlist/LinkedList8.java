package linkedlist;

import linkedlist.LinkedList7.Node;

public class LinkedList8 {
    /**
     * 풀이 실패.
     *
     * Loop detection
     * Given a circular linked list,
     * implement an algorithms that returns the node at the beginning of the loop
     * <p>
     * -> 개념을 모르면 풀기 힘들 듯 ..
     * ( FLOYD'S CYCLE DETECTION ALGORITHMS )
     */

    public static void main(String[] args) {
        // Create
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // link
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;

        Node node = loopDetection(node1);
        System.out.println(node.data);
    }

    static boolean isCircularLinkedList(Node head) {
        /** list에 cycle이나 loop이 있는지 확인
         * -> FLOYD'S CYCLE DETECTION ALGORITHMS이라 부름.
         * 또는 FLOYD'S TORTOISE & THE HARE ALGORITHMS라 부른다.*/
        Node hare = head; // 2배 빨리 가는 토끼
        Node tortoise = head; // 거북이는 한 칸씩

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            // 둘이 만난다 -> circular linked list다.
            if (hare == tortoise) {
                break;
            }
        }

        // null로 끝난다 -> circular linked list가 아니다.
        if (hare == null || hare.next == null) {
            return false;
        }
        return true;
    }

    // TIME : O(N)
    // SPACE : O(1)
    static Node loopDetection(Node head) {
        Node hare = head;
        Node tortoise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise) {
                break;
            }
        }

        if (hare == null || hare.next == null) {
            return null;
        }

        // cycle 찾았으면 순환되는 첫째 노드 반환
        tortoise = head;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }
}
