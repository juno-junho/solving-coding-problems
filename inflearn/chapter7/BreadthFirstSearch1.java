import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch1 {
    static class Node {
        private int data;

        private Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLt() {
            return lt;
        }

        public void setLt(Node lt) {
            this.lt = lt;
        }

        public Node getRt() {
            return rt;
        }

        public void setRt(Node rt) {
            this.rt = rt;
        }
    }

    private Node root;

    public void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);  // queue에 root node 넣기
        int level = 0;
        while (!queue.isEmpty()) {  // 비어 있으면 멈춘다.
            int len = queue.size();
            System.out.print(level  + " :");
            for (int i = 0; i < len; i++) { // 원소 개수만큼 for 돌기
                Node current = queue.poll();
                System.out.print(current.getData() + " ");
                if (current.getLt() != null) {  // 왼쪽 자식 queue에 넣기
                    queue.offer(current.getLt());
                }
                if (current.getRt() != null) {  // 오른쪽 자식 queue에 넣기
                    queue.offer(current.getRt());
                }
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch1 tree = new BreadthFirstSearch1();
        tree.root = new Node(1);
        tree.root.setLt(new Node(2));
        tree.root.setRt(new Node(3));
        tree.root.getLt().setLt(new Node(4));
        tree.root.getLt().setRt(new Node(5));
        tree.root.getRt().setLt(new Node(6));
        tree.root.getRt().setRt(new Node(7));
        tree.bfs(tree.root);
    }
}
