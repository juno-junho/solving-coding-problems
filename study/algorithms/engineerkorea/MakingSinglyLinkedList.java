package engineerkorea;
class MakingSinglyLinkedList {
    static class Node{
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }

        void append(int data) {
            Node end = new Node(data);  // 새로운 node 생성
            Node n = this;
            while (n.next != null) {    // 맨 끝 node로 이동하기
                n = n.next;
            }
            n.next = end;
        }

        void delete(int data) {
            Node n = this;
            while (n.next != null) {
                if (n.next.data == data) {  // 다음 node의 데이터랑 같으면 n.next를 바꾸기.
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
        }

        void retreive() {
            Node n = this;
            while (n.next != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    /**
     * 문제점 : 첫번째 node를 삭제할 수 없다.
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retreive();

        head.delete(2);
        head.delete(3);
        head.retreive();
    }
}
