class DepthFirstSearch1 {
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

    public void dfs(Node node) {
        if (node == null) return; // 말단 node로 온 것
        else{
            System.out.print(node.getData() + " "); // 전위순회
            dfs(node.getLt());
//            System.out.print(node.getData() + " "); // 중위순회
            dfs(node.getRt());
//            System.out.print(node.getData() + " "); // 후위순회
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch1 tree = new DepthFirstSearch1();
        tree.root = new Node(1);
        tree.root.setLt(new Node(2));
        tree.root.setRt(new Node(3));
        tree.root.getLt().setLt(new Node(4));
        tree.root.getLt().setRt(new Node(5));
        tree.root.getRt().setLt(new Node(6));
        tree.root.getRt().setRt(new Node(7));
        tree.dfs(tree.root);
    }
}
