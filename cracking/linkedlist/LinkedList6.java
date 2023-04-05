package linkedlist;

import linkedlist.SinglyLinkedListSetUp.Node;

import java.util.Stack;

public class LinkedList6 {
    /**
     * implement a function to check if a linked list is a palindrome
     */
    public static void main(String[] args) {

        SinglyLinkedListSetUp linkedList = new SinglyLinkedListSetUp();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(0);
        linkedList.append(0);
        linkedList.append(4);
        linkedList.append(2);
        linkedList.append(1);

        System.out.println(isPalindrome(linkedList.header));

        linkedList.print();
    }

    /**
     * palindrome인지 어떻게 알지..
     * runner 사용.. 끝에서 부터 재귀로 값반환
     * 머리가 안돌아간다..
     * <p>
     * Stack 사용
     * 길이가 odd, even으로 나눈다.
     * odd -> middle 신경 안써도 된다.
     * even -> 대칭
     * <p>
     * fast & slow pointer technique 사용해서 중간 구한다.
     */
    // TIME : O(N)
    // STACK : O(N)
    static boolean isPalindrome(Node head) {
        if (head.next == null) {
            return false;
        }
        // 중간 index 찾는다.
        Node fast = head;
        Node slow = head;
        Stack<Node> stack = new Stack<>();

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 2 - 3 - 4 - 4 - 3 - 2 일때 처음 4가 slow 위치
        // 1 - 2 - 3 - 2 - 1 일때 처음 2가 slow 위치
        while (head != slow) {
            stack.push(head.next);
            head = head.next;
        }

        if (head.next != stack.peek()) {// 길이가 홀수 개면 head 한칸 건너뛰기
            head = head.next;
        }

        while (head.next != null) {

            if (stack.pop().data != head.next.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    static boolean isPalindrome_sol1(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // ignore value when it is odd
        if (fast != null) { // fast가 null 이면 even 아니면 odd
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.peek() != slow.data) {
                return false;
            }
            slow = slow.next;
            stack.pop();
        }
        return true;
    }
}
