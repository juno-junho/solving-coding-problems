class DepthFirstSearch1 {

    Node root;

    public void dfs(Node rooot) {
        if (root == null) return;
        else{
            System.out.print(root.getData() + " ");
            dfs(root.getLt());
            dfs(root.getRt());
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
class Node {
    int data;
    Node lt, rt;

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

