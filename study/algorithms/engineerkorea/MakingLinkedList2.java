package engineerkorea;

class MakingLinkedList2 {
    Node header;
    static class Node{
        int data;
        Node next = null;
    }
    MakingLinkedList2(){
        header = new Node();
    }
    void append(int data) {
        Node end = new Node();  // 새로운 node 생성
        end.data = data;
        Node n = header;
        while (n.next != null) {    // 맨 끝 node로 이동하기
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == data) {  // 다음 node의 데이터랑 같으면 n.next를 바꾸기.
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retreive() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups() {
        // 정렬이 안되있는데, 중복 제거. buffer 쓰지 않고
        // time complexity : O(n^2) / space complexity : O(1)
        Node n = header;
        while (n != null && n.next != null) { // runner가 마지막을 지워버렸는데 n은 마지막 노드로 가버리는것을 방지.
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    // r.data가 아닌 r.next.data와 비교하는 이유는 r은 끝까지 돌지 않고, 전에서 next만 갈아치우면 되니깐 그게 더 나음.
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}

class LinkedListNode {
    public static void main(String[] args) {
        MakingLinkedList2 ll = new MakingLinkedList2();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(2);
        ll.retreive();
        ll.removeDups();
        ll.retreive();
    }
}

