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

    // TIME : O(N + M)
    // SPACE : O(1)
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

    // TIME : O(N+M)
    // SPACE : O(N + M)  최대
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

    /**
     * sol 1 ) 내가 생각한 풀이
     * 1. 길이 계산한다.
     * 2. 포인터를 다시 앞으로 보낸다.
     * 3. 길이 차이만큼 긴 리스트의 포인터를 옮긴다.
     * 4. null까지 두 list 돌면서 node 같은지 확인
     * <p>
     * 유사한 답지 풀이 ) - 추가한 작업 : 마지막 노드 비교
     * 1. 각 노드 돌면서 길이와 마지막 노드 구한다.
     * 2. 마지막 노드 비교 -> 참조값 다르면 교집합 없음 반환
     * 3. 위 풀이와 동일.
     * <p>
     * sol 2 ) 수학적인 방법
     * 1. 두 포인터를 설정한다. (각 리스트)
     * 2. 두 포인터를 각각 한칸씩 옮겨 끝에 도착하면 반대편 리스트의 처음으로 리셋시킨다.
     * 3. 계속반복하다보면 언젠간 intersecting node에서 만난다.
     */

    static class Result {
        Node tail;
        int size;

        Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    // TIME : O(N+M)
    // SPACE: O(1)
    static Node findIntersection_sol1(Node list1, Node list2) {
        if (list1 == null | list2 == null) {
            return null;
        }
        // 마지막 노드, size 구한다
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        // 마지막 노드가 다르면 교집합 없다.
        if (result1.tail != result2.tail) {
            return null;
        }

        Node shorter = result1.size < result2.size ? list1 : list2;
        Node longer = result1.size < result2.size ? list2 : list1;

        // 차이만큼 옮기기
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    private static Node getKthNode(Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    private static Result getTailAndSize(Node list) {
        if (list == null) {
            return null;
        }
        int size = 1;
        Node current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }


    // TIME : O(N + M) -> O(N) where N is the length of the longer list
    // SPACE : O(1)
    static Node findIntersection_sol2(Node list1, Node list2) {
        Node firstPointer = list1;
        Node secondPointer = list2;

        while (firstPointer != secondPointer) {
            if (firstPointer == null) {
                firstPointer = list2;
            }
            if (secondPointer == null) {
                secondPointer = list1;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        return firstPointer;
    }

}
