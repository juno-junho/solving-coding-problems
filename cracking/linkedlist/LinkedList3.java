package linkedlist;

import linkedlist.SinglyLinkedListSetUp.Node;

public class LinkedList3 {
    /**
     * 중간 노드 삭제
     * singly linkedlist -> 중간에 있는 노드 하나 삭제하는 알고리즘.
     * 단, 삭제할 노드에만 접근 할 수 있다.
     *
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
        deleteNode(linkedList.header.next.next);    // 2
        linkedList.print();
    }

    /**
     * 정답을 알고 있는 문제.
     * 현재 노드를 다음 노드랑 동일한 값으로 바꾸고, 다음 노드를 삭제하면 된다.
     */
    // TIME : O(1)
    // SPACE: O(1)
    static boolean deleteNode(Node nodeToRemove) {
        // 다음 노드 값으로 바꾸기
        nodeToRemove.data = nodeToRemove.next.data;
        // 다음 노드 삭제
        nodeToRemove.next = nodeToRemove.next.next;
        return true;
    }

    /**
     * solution
     * 단점 : 마지막 노드인 경우 삭제 할 수 없다.
     */
    static boolean deleteNode_sol(Node nodeToRemove) {
        if (nodeToRemove == null || nodeToRemove.next == null) {
            return false;
        }
        Node next = nodeToRemove.next;
        //값 변경
        nodeToRemove.data = next.data;

        // 삭제
        nodeToRemove.next = next.next;
        return true;
    }
}
