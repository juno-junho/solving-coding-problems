package linkedlist;

import linkedlist.SinglyLinkedListSetUp.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedList1 {

    public static void main(String[] args) {
        SinglyLinkedListSetUp linkedList = new SinglyLinkedListSetUp();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(50);
        linkedList.append(50);
        linkedList.append(50);
        linkedList.append(2);
        linkedList.append(29);
        linkedList.print();

        deleteDups_2(linkedList.header);
        linkedList.print();
    }

    /**
     *
     * 정렬되어 있지 않은 연결리스트가 주어졌을 때,
     * 중복되는 원소 제거 코드 작성하기

     * 1. 임시 버퍼 set 사용
     * 2. 임시 버퍼 사용 X

     * 내 풀이와 정답이 일치.
     */

    // TIME : O(N)
    // SPACE : O(N)
    static void deleteDups(Node node) {
        Set<Integer> set = new HashSet<>();

        while (node.next != null) {
            Node nextNode = node.next;
            if (set.contains(nextNode.data)) {
                node.next = node.next.next;
                continue;
            }
            set.add(nextNode.data);
            node = node.next;
        }
    }

    /**
     * 임시 버퍼 사용 x
     * runner한테 갔다오라고 시키기.
     * 왜 구현을 못하는거지? runner가 제거하고 와야한다.
     */
    // TIME : O(N^2)
    // SPACE : O(1)
    static void deleteDups_2(Node node) {
        while (node.next != null) {
            Node pointer1 = node;
            Node runner = node.next;

            while (runner.next != null) {
                if (pointer1.next.data == runner.next.data) {
                    runner.next = runner.next.next;
                    continue;
                }
                runner = runner.next;
            }
            node = node.next;
        }
    }
}
