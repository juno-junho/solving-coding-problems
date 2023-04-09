package linkedlist;

import linkedlist.LinkedList7.Node;

// TODO : 책의 SOL2 재귀풀이 이해하기.

/**
 * sol2 : 책풀이 - 재귀 참고
 */
public class LinkedList5 {
    /**
     * 리스트의 합 :
     * 연결리스트로 숫자를 표현할 때, 각 노드가 자릴수 하나를 가리키는 방식으로 표현
     * 각 숫자는 역순으로 배열.
     * 첫번째 자리수가 리스트의 맨 앞에 위치하도록 배열.
     * 두 수를 더해 그 합을 연결리스트로 반환하는 함수 구해라.
     * <p>
     * e.g (7 - 1 - 6) + (5 - 9 - 2 - 1)  : 617 + 1295
     * output: 2 - 1 - 9 - 1          : 1912
     */
    public static void main(String[] args) {

        System.out.println(11 / 10);

        Node list1_1 = new Node(7);
        Node list1_2 = new Node(1);
        Node list1_3 = new Node(6);
//        Node list1_4 = new Node(9);

        // Links Nodes for List 1
        list1_1.next = list1_2;
        list1_2.next = list1_3;
//        list1_3.next = list1_4;

        Node list2_1 = new Node(5);
        Node list2_2 = new Node(9);
        Node list2_3 = new Node(2);
        Node list2_4 = new Node(1);

        list2_1.next = list2_2;
        list2_2.next = list2_3;
        list2_3.next = list2_4;
        Node node = sumLists_sol1(list1_1, list2_1);
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    /**
     * 내 풀이 : == 정답 풀이
     * 1. 돌면서 더해 새 노드 생성한다.
     * 2. 10 이상이면 1의자리로 생성하고 나머지는 넘겨서 다음번에 추가해준다.
     * 3. 한쪽이 끝나면 carry와 합쳐서 남은 노드 그대로 노드 생성해 붙혀준다.
     */
    // TIME : O (N ) N은 둘중 더 긴것
    // SPACE : O(1)
    static Node sumLists(Node head1, Node head2) {

        Node pointer1 = head1;
        Node pointer2 = head2;

        Node result = new Node(0);
        Node pointer3 = result;

        int carry = 0;
        while (pointer1 != null || pointer2 != null) { // 끝날때 까지 돈다.

            int sum = 0;
            if (pointer1 == null) {
                sum = pointer2.data + carry;
                pointer2 = pointer2.next;
            } else if (pointer2 == null) {
                sum = pointer1.data + carry;
                pointer1 = pointer1.next;
            } else {
                sum = pointer1.data + pointer2.data + carry;
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            result.next = new Node(sum % 10);
            result = result.next;
            carry = sum / 10;
        }
        if (carry == 1) {
            result.next = new Node(carry);
        }
        return pointer3.next;
    }


    // TIME : O(N) N은 둘중 더 긴것
    // SPACE : O(1) 
    static Node sumLists_sol1(Node list1, Node list2) {
        int result = 0;
        int carry = 0;

        Node outputHead = null;
        Node outputPointer = null;

        while (list1 != null || list2 != null || carry != 0) { // list1, list2가 null이고 carry가 0이면 탈출
            if (list1 != null) {
                result += list1.data;
                list1 = list1.next;
            }
            if (list2 != null) {
                result += list2.data;
                list2 = list2.next;
            }
            result += carry;
            carry = result / 10;
            Node newNode = new Node(result % 10);

            if (outputHead == null) {
                outputHead = newNode;
                outputPointer = outputHead;
            } else {
                outputPointer.next = newNode;
                outputPointer = newNode;
            }
            result = 0;
        }

        return outputHead;
    }

    /**
     * 책 풀이 - 재귀를 이용한 풀이
     * 근데 이것은 두 linked list 길이가 같을때만 유효한것..
     */
    static Node sumLists_sol2(Node list1, Node list2, int carry) {
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(0);
        int value = carry;
        if (list1 != null) {
            value += list1.data;
        }
        if (list2 != null) {
            value += list2.data;
        }
        result.data = value % 10;

        if (list1 != null || list2 != null) {
            Node more = sumLists_sol2(list1 == null ? null : list1.next,
                    list2 == null ? null : list2.next,
                    value >= 0 ? 1 : 0);
            result.next = more;
        }
        return result.next;
    }
}
