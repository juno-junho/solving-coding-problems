package linkedlist;

import linkedlist.SinglyLinkedListSetUp.Node;

import java.util.Stack;
// TODO: 재귀 부분 이해하기. STACK와 재귀의 변환관계 이해
/**
 * solution 코드 다시 학습하기.
 * 특히 재귀 부분 이해하기.

 * Stack chapter - stack이 유용한 경우 참고
 * - stack은 재귀 알고리즘을 iterative한 형태로 바꿔서 구현 할 수 있다.
 * 이 문제가 그 예시가 될 수 있다.
 */
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
     *  - Stack 사용
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
        while (head != slow) {  // 이거 위에서 while 돌면서 같이 처리해 줄 수 있었다.  head를 안쓰고 slow를 쓰면됨.
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

    /**
     * sol 2. 순환적 접근법.
     */
    static boolean isPalindrome_sol2(Node head) {
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

    /**
     * sol 1. 뒤집어서 비교한다.
     * 뒤집어 비교할 ㄸ는 리스트의 절반만 비교하면 된다.
     */
    static boolean isPalindrome_sol1(Node head) {

        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);

    }

    private static Node reverseAndClone(Node head) {
        Node header = null;
        while (head != null) {
            Node node = new Node(head.data);    // 복사
            node.next = header;
            header = node;
            head = head.next;
        }
        return header;
    }

    private static boolean isEqual(Node one, Node two) {
        while (one != null & two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    /**
     * sol 3. 재귀적 접근법
     */
    static class Result {
        Node node;
        boolean result;

        public Result(Node head, boolean result) {
            this.node = head;
            this.result = result;
        }
    }
    static boolean isPalindrome_sol3(Node head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    static Result isPalindromeRecurse(Node head, int length) {
        if (head == null || length <= 0) {  // 노드 개수 even
            return new Result(head, true);
        } else if (length == 1) {   // 노드 개수 odd
            return new Result(head.next, true);
        }

        // 리스트 재귀적으로 호출
        Result res = isPalindromeRecurse(head.next, length - 2);

        // 아래 호출 결과 회문이 아니라는 사실이 밝혀지면, 그 결과값 반환
        if (!res.result || res.node == null) {
            return res;
        }

        // 두 노드 값이 같은지 확인
        res.result = (head.data == res.node.data);

        // 그 다음 비교할 노드 반환
        res.node = res.node.next;

        return res;
    }

    static int lengthOfList(Node node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}