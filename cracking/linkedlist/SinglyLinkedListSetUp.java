package linkedlist;

import java.util.HashMap;
import java.util.Map;

class SinglyLinkedListSetUp {
    /**
     * header를 하나의 빈 노드로 만든다.
     * -> 첫 노드 조작 가능
     */
    Node header;

    static class Node {
        int data;
        Node next = null;

        Node(){

        }

        Node(int data) {
            this.data = data;
        }

        public Node get(int index) {
            int total = 0;
            while (this.next != null) {
                total++;
                if (index == total) {
                    return this.next;
                }
            }
            return null;
        }
    }

    public SinglyLinkedListSetUp() {
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

    Node get(int index) {
        Node head = header;
        int count = 0;
        while (head.next != null) {
            head = head.next;
            count++;
            if (index == count) {
                return head;
            }
        }
        return null;
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
}
