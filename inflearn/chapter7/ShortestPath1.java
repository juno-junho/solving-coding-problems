import java.util.LinkedList;
import java.util.Queue;

class ShortestPath1 {
    // Tree 말단 노드 까지의 가장 짧은 경로 구하기


    private Node root;
    // 방법 1. dfs로 해결하기.
    int dfs(int level, Node root) {
        // level이 여기서 정의하는 거리. 이동횟수가 됨.
        // root가 말단노드일때 level return하기
        if (root.getLt() == null && root.getRt() == null) return level;
        return Math.min(dfs(level + 1, root.getLt()), dfs(level + 1, root.getRt()));
    }

    int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node current = queue.poll();
                if (current.getRt() == null && current.getLt() == null) return level;
                if (current.getLt() != null) queue.offer(current.getLt());
                if (current.getRt() != null) queue.offer(current.getRt());
            }
            level++;
        }
        // 여기 오지는 않음.
        return level;
    }

    public static void main(String[] args) {
        ShortestPath1 tree = new ShortestPath1();
        tree.root = new Node(1);
        tree.root.setLt(new Node(2));
        tree.root.setRt(new Node(3));
        tree.root.getLt().setLt(new Node(4));
        tree.root.getLt().setRt(new Node(5));
        System.out.println(tree.dfs(0, tree.root));
    }
}

class Node {
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
