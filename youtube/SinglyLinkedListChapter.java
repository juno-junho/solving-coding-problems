public class SinglyLinkedListChapter {
    /**
     * 아래 코드 문제점 :
     * Head를 삭제를 못함.
     *
     */
    static class Node {

        public int data;
        public Node next = null;

        public Node(int data) {
            this.data = data;
        }

        void append(int data) {
            Node end = new Node(data);
            Node head = this;
            while (head.next != null) {
                head = head.next;
            }
            head.next = end;
        }

        void remove(int data) {
            Node head = this;
            while (head.next != null) {
                if (head.next.data == data) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
        }

        void print() {
            Node head = this;
            while (head.next != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.append(6);
        head.append(7);
        head.append(8);
        head.append(9);
        head.append(10);

        head.print();
        // 삭제가 안된다.
        head.remove(1);

        head.print();
    }



}

