import java.util.HashMap;
import java.util.Map;

class SinglyLinkedListVer2 {
    /**
     * header를 하나의 빈 노드로 만든다.
     * -> 첫 노드 조작 가능
     */
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    public SinglyLinkedListVer2() {
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

    /**
     * LinkedList에서 중복된 값 제거
     * <p>
     * TIME : O(N^2)
     * SPACE : O(1)
     */
    void removeDups() {
        Node n = header;
        while (n != null && n.next != null) { // 마지막 노드 까지 돈다.
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
//                    remove(r.next.data);
                    r.next = r.next.next; // Node를 삭제하는 것.
                } else {
                    r = r.next; // 다음 노드 주소값을 복사하는 것.
                }
            }
            n = n.next;
        }
    }

    /**
     * LinkedList에서 중복된 값 제거 - Buffer 이용
     * <p>
     * TIME : O(N)
     * SPACE : O(N)
     */
    void removeDupsUsingBuffer() {
        Map<Integer, Boolean> buffer = new HashMap<>();
        Node n = header;
        while (n.next != null) {
            if (buffer.getOrDefault(n.next.data, false)) {
                n.next = n.next.next;
                continue;
            }
            buffer.put(n.next.data, true);
            n = n.next;
        }
    }

    /**
     * 단방향 LinkedList에서 끝에서 K 번째 노드를 찾는 알고리즘을 구현하여라
     * 방법 1. index로
     */
    private static Node kthToLast(Node first, int k) {
        Node n = first;
        int total = 1;
        while (n.next != null) {
            total++;
            n = n.next;
        }
        n = first;
        for (int i = 1; i < total - k + 1; i++) {
            assert n != null;
            n = n.next;
        }
        return n;
    }

    /**
     * 단방향 LinkedList에서 끝에서 K 번째 노드를 찾는 알고리즘을 구현하여라
     * 방법 2. 재귀 호출
     * TIME : O(N) (linkedlist 길이 n)
     * SPACE : O(N)
     */
    private static int kthToLast_2(Node n, int k) {
        if (n == null) {
            return 0;
        }
        int count = kthToLast_2(n.next, k) + 1;
        if (count == k) {
            System.out.println("Last k(" + k + ") th data is " + n.data);
        }
        return count;
    }

    /**
     * 자바는 pass by reference가 없다.
     * count라는 변수의 주소를 전달 할 수 있으면 다음 함수 호출하고 count 값 받지 않아도 값이 어떻게 변했나 보면 된다.
     * 함수는 찾아낸 node만 반환하면 된다.
     * <p>
     * 객체 / 배열은 stack에 pointer만 저장하기에 그것을 이용하는것.
     * count를 객체 안에 넣어 객체 주소를 전달하면 된다.
     */

    static class Reference {
        public int count = 0;
    }

    private static Node kthToLast_3(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }
        Node foundNode = kthToLast_3(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return foundNode;
    }

    /**
     * 단방향 LinkedList에서 끝에서 K 번째 노드를 찾는 알고리즘을 구현하여라
     * 방법 3. 포인터
     * TIME : O(N)
     * SPACE : O(1) - 별도의 버퍼 사용 X
     */
    private static Node kthToLast_4(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
            if (p1 == null) {   // 값이 없다.
                return null;
            }
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    /**
     * 단방향 Linked List에서 중간에 있는 노드를 삭제하시오.
     * 단, 당신은 첫번째 노드가 어디에 있는지 모르고, 오직 삭제할 노드만 가지고 있다.
     * TIME: O(1)
     * SPACE: O(1)
     */
    private static boolean deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            return false;
        }
        Node nextNode = nodeToDelete.next;
        nodeToDelete.data = nextNode.data; // 값 복사
        nodeToDelete.next = nextNode.next; // 주소값 복사
        return true;
    }

    /**
     * LinkedList에 있는 노드들을 x 값을 기준으로 값이 작은것들은 왼쪽, 큰것들은 오른쪽으로 나누시오.
     * (단, x는 오른쪽 파트 어디에 놓아도 상관 없다)
     * <p>
     * // first와 next의 관계를 모르겠다.. 그림그리니 이해가 된다..
     */
    private static Node partition(Node firstNode, int x) {
        // 4개의 포인터 선언 (주소값을 갖는 포인터)
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;

        while (firstNode != null) { // 마지막 노드까지 돈다
            // 새로운 노드 추가 (따로 노드 하나씩 떼주는 작업) - node간 연관관계를 없애 주는게 필요!
            Node next = firstNode.next;
            firstNode.next = null;

            if (firstNode.data < x) {   // 첫째 줄에 붙힌다.
                if (s1 == null) {   // 처음
                    s1 = firstNode;
                    e1 = firstNode;
                } else {
                    System.out.println("1 e1.data : " + e1.data + " n.data : " + firstNode.data);
                    e1.next = firstNode; // e1의 다음 주소값으로 n을 갖게 하고
                    System.out.println("2 e1.data : " + e1.data + " n.data : " + firstNode.data);
                    e1 = firstNode; // e1도 n 노드의 위치로 이동한다
                    System.out.println("3 e1.data : " + e1.data + " n.data : " + firstNode.data);
               /*     e1.next = firstNode;    // e1의 처음 다음 주소값을 해당 노드로 설정
                    e1 = firstNode;         // 그리고 e1또한 다음 주소값으로 이동*/
                }
            } else {    //  둘째 줄에 붙힌다.
                if (s2 == null) {   // 처음
                    s2 = firstNode;
                    e2 = firstNode;
                } else {
                    System.out.println("1 e2.data : " + e2.data + " n.data : " + firstNode.data);
                    e2.next = firstNode; // e2의 다음 주소값으로 n을 갖게 하고
                    System.out.println("2 e2.data : " + e2.data + " n.data : " + firstNode.data);
                    e2 = firstNode; // e2도 n 노드의 위치로 이동한다
                    System.out.println("3 e2.data : " + e2.data + " n.data : " + firstNode.data);
                  /*  e2.next = firstNode;
                    e2 = firstNode;*/
                }
            }
//            first = first.next;
            firstNode = next;
        }
        // 두 라인 붙히기
        if (s1 == null) {   // s1이 없을 경우
            return s2;
        }
        e1.next = s2;
        return s1;

        /**
         *  처음 내가 시도한 방법
         *  부족한점 : e2 포인터가 있으면, 어떻게 그 다음 노드를 가리키게 하지?를 해결 못함. (그림을 그리지 못함. stack과 heap의 관계)
         while (first != null) { //돈다

         first = first.next;
         if (first.data >= x) {
         if (s2 == null) {
         s2 = first;
         e2 = first;
         }
         e2.next = first;
         e2 = first;
         e2 = first;
         s2.next = e2;

         }else {
         if (s1 == null) {
         s1 = first;
         }
         s2 = first;
         }
         first = first.next;
         }*/
        // 붙히기
    }


    private static Node partition_2(Node firstNode, int x) {
        // pointer 두개 선언
        Node head = firstNode;
        Node tail = firstNode;

        while (firstNode != null) {
            Node nextNode = firstNode.next; // node 주소 가지고 있음.
            firstNode.next = null;

            if (firstNode.data < x) {
                firstNode.next = head;
                head = firstNode;

            } else {
                tail.next = firstNode;
                tail = firstNode;
            }

            firstNode = nextNode;
        }
//        tail.next = null;
        return head;

    }

    public static void main(String[] args) {
        SinglyLinkedListVer2 ll = new SinglyLinkedListVer2();

        ll.append(7);
        ll.append(2);
        ll.append(8);
        ll.append(5);
        ll.append(3);
        ll.append(4);
        ll.print();

//        ll.remove(1);
//        ll.removeDupsUsingBuffer();
//        int k = 0;
//        Reference reference = new Reference();
/*        Node found = kthToLast_4(ll.header, k);
        assert found != null;
        System.out.println(found.data);*/


        Node node = partition_2(ll.get(1), 5);
        System.out.println("=================");
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
        System.out.println("=================");
        ll.print();
    }


}
