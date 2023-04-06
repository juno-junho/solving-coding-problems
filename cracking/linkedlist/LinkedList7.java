package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList7 {
    /**
     * 단방향 linkedlist 2개 주어졌을때, 두 리스트의 교집합 노드 찾아 반환
     * <p>
     * 접근 방법 :
     * 1. runner로 각 리스트 길이 구한다.
     * 2. 긴 list를 짧은 list 처럼 앞에서 잘라 길이 맞춘다.
     * 3. 길이만큼 포인터로 돌면서 노드 주소가 같은 것
     * <p>
     * 풀이 2) 각 노드를 set에 저장하고, 넣었을때 길이가 변하지 않으면 그 값 리턴?
     */
    static class Node {

        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        /**
         * 1 -> 2 -> 3 -> 4 \
         *                   7 -> 8 -> 9 -> 10
         *           5 -> 6 /
         */
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7;

        node5.next = node6;
        node6.next = node7;

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        Node intersector = findIntersection_2(node1, node5);
        System.out.println("The intersecting node: " + intersector.data);
    }

    /**
     * 접근 방법 :
     * 1. 각 리스트 길이 구한다.
     * 2. 긴 list를 짧은 list 처럼 앞에서 잘라 길이 맞춘다.
     * 3. 길이만큼 포인터로 돌면서 노드 주소가 같은 것
     */
    static Node findIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        Node fistNode = list1;
        int firstNodeLength = 0;
        Node secondNode = list2;
        int secondNodeLength = 0;

        while (fistNode != null) {
            firstNodeLength++;
            fistNode = fistNode.next;
        }
        while (secondNode != null) {
            secondNodeLength++;
            secondNode = secondNode.next;
        }

        int length = Math.min(firstNodeLength, secondNodeLength);

        if (firstNodeLength > secondNodeLength) {
            // 첫 노드 삭제
            for (int i = 0; i < firstNodeLength - secondNodeLength; i++) {
                list1 = list1.next;
            }
        } else if (secondNodeLength > firstNodeLength) {
            for (int i = 0; i < secondNodeLength - firstNodeLength; i++) {
                list2 = list2.next;
            }
        }
        // 길이 같아짐.
        for (int i = 0; i < length; i++) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }

    static Node findIntersection_2(Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        // 길이는 동일하게 구한다.
        Node fistNode = list1;
        int firstNodeLength = 0;
        Node secondNode = list2;
        int secondNodeLength = 0;

        while (fistNode != null) {
            firstNodeLength++;
            fistNode = fistNode.next;
        }
        while (secondNode != null) {
            secondNodeLength++;
            secondNode = secondNode.next;
        }

        int length = Math.max(firstNodeLength, secondNodeLength);
        // 돌면서 set 확인
        Set<Node> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (list1 != null && list2 != null) {
                int beforeAddList1 = set.size();
                set.add(list1);
                int afterAddList1 = set.size();
                if (beforeAddList1 == afterAddList1) {
                    return list1;
                }
                set.add(list2);
                int afterAddList2 = set.size();
                if (afterAddList1 == afterAddList2) {
                    return list2;
                }
            }
            if (list1 == null) {
                while (list2 != null) {
                    int before = set.size();
                    set.add(list2);
                    int after = set.size();
                    if (after == before) {
                        return list2;
                    }
                    list2 = list2.next;
                }
            } else if (list2 == null) {
                while (list1 != null) {
                    int before = set.size();
                    set.add(list1);
                    int after = set.size();
                    if (after == before) {
                        return list1;
                    }
                    list1 = list1.next;
                }
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }
}
