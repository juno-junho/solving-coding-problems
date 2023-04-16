public class TreeTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
    }

    static class Tree{
        private Node root;

        public void setRoot(Node node) {
            this.root = node;
        }

        public Node getRoot() {
            return root;
        }

        public Node makeNode(Node left, int data, Node right) {
            Node node = new Node();
            node.data = data;
            node.left = left;
            node.right = right;
            return node;
        }

        /**
         * Left -> Root -> Right
         */
        public void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.data + " -> ");
                inOrder(node.right);
            }
        }

        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " -> ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.data + " -> ");
            }
        }
    }

    /**
     *     (1)
     *     / \
     *   (2) (3)
     *   / \
     *  (4)(5)
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node n4 = tree.makeNode(null, 4, null);
        Node n5 = tree.makeNode(null, 5, null);
        Node n3 = tree.makeNode(null, 3, null);
        Node n2 = tree.makeNode(n4, 2, n5);
        Node n1 = tree.makeNode(n2, 1, n3);

        tree.setRoot(n1);

        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());
    }
}
