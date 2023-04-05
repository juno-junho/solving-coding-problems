package linkedlist;

import linkedlist.SinglyLinkedListSetUp.Node;

public class LinkedList2 {
    /**
     * 뒤에서 k번째 원소 구하기
     * singlyLinkedList가 주어졌을때, 뒤에서 k번째 원소를 찾는 알고리즘
     * <p>
     * 학습한 내용 / 개선 사항:
     * - 재귀적으로 호출할 때, return 값이 여러개일 경우 wrapper class를 생성하자!
     * - 재귀 -> DFS, BFS, 백트래킹 학습 후 더 연습하기
     */

    public static void main(String[] args) {

        SinglyLinkedListSetUp linkedList = new SinglyLinkedListSetUp();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(50);
        linkedList.append(50);
        linkedList.append(50);
        linkedList.append(2);
        linkedList.append(29);
        linkedList.append(1);
        linkedList.print();

        System.out.println(printKthToLast(linkedList.header, 1));
        System.out.println(printKthToLast(linkedList.header, 2));
        System.out.println(printKthToLast(linkedList.header, 3));
        System.out.println(printKthToLast(linkedList.header, 4));
        System.out.println(printKthToLast(linkedList.header, 5));
        System.out.println(printKthToLast(linkedList.header, 6));
        System.out.println(printKthToLast(linkedList.header, 7));
        System.out.println(printKthToLast(linkedList.header, 8));
//        System.out.println(printKthToLast(linkedList.header, 0));
//        linkedList.print();
    }

    /**
     * runner를 사용하는데, runner = node + k 를 해서 runner가 null에 도착했을때, 그때 node의 값을 반환하면 된다.
     * 문제는 k가 범위를 벗어났을때 NPE 발생.
     * Header 뒤에 붙는 값이 없을때에도 NPE 발생
     * <p>
     * 두번째 풀이는 LENGTH를 미리 구하고 LENGTH-K만큼 움직이는 방법이 있을것..
     * <p>
     * answer )
     * - 재귀적 풀이 추가 -> wrapper class 개념 도입.
     * - 나머지는 내 풀이 일치
     */
    // TIME : O(N)
    // SPACE: O(1)
    static int printKthToLast(Node header, int k) {
        Node node = header.next;
        Node runner = node;
        // runner 설정
        for (int i = 0; i < k; i++) {
            runner = runner.next;
        }

        // runner와 node를 null까지 보낸다.
        while (runner != null) {
            node = node.next;
            runner = runner.next;
        }
        return node.data;
    }

    /**
     * 재귀적 방법
     * 마지막 element -> 0 반환 &&
     * 부모 메서드는 그 값에 1 더하기
     * -> k가 되는 순간 뒤에서 k번째에 도달하게 된다.
     * <p>
     * 하지만 return의 경우 index를 return 하므로, 값을 return 할 수가 없다.
     * -> wrapper class 사용
     */
    static int printKthToLast_sol1(Node header, int k) {

        if (header == null) {
            return 0;
        }

        int index = printKthToLast_sol1(header.next, k) + 1;
        if (index == k) {
            System.out.println("뒤에서" + k + "번째 노드는 " + header.data + "입니다.");
        }
        return index;
    }

    /**
     * wrapper 클래스 사용
     */
    static class Index {
        int value = 0;
    }

    Node kthToLast(Node head, int k) {
        Index index = new Index();
        return kthToLast(head, k, index);
    }

    // TIME : O(N)
    // SPACE : O(N) -> stack 공간 포함
    private Node kthToLast(Node head, int k, Index index) {
        if (head == null) {
            return null;
        }
        Node node = kthToLast(head.next, k, index);
        index.value += 1;
        if (index.value == k) {
            return head;
        }
        return node;
    }

    /**
     * 내 풀이와 동일한 풀이
     * iterative 방법

     * TIME : O(N)
     * SPACE : O(1)
     */
    public static Node nthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
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

}
