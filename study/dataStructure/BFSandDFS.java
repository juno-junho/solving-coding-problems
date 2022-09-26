import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * dfs는 말그대로 하나의 child node를 방문했으면 해당 child node를 끝까지 파고 드는 것. (마지막 node까지 파고들고 다시 올라와 형제 노드로)
 * bfs는 시작점에서 child node들을 먼저 방문하고 자식의 자식을 방문하고 .. level 단위로 검색을 하는 것.
 */
class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent; // 인접한 노드와의 관계는 linkedList로 구현. (인접한 노드 == 자식 노드)
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    
    Node[] nodes;

    Graph(int size) {    // 노드 개수 고정
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {  // 두 노드의 관계를 저장하는 함수
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    void dfs(){
        dfs(0);
    }

    void dfs(int index) {
        /**
         * stack을 이용한 구현 :
         * 1. stack을 하나 만들고 시작 node를 일단 하나 넣는다
         * 2. stack에서 node를 하나 꺼내서 해당 child node들을 전부 stack에 넣고 꺼낸 node는 출력.
         * child node를 stack에 넣을때에는 한번 넣은것은 다시 넣지 않는다.
         */
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }
    void bfs() {
        bfs(0);
    }

    /**
     * queue를 하나 만들어 시작 노드를 하나 넣고 시작함
     * 1. queue에서 node하나 꺼내서 해당 child node 들을 전부 queue에 넣고 꺼낸 노드는 출력한다.
     * 여기서 한번 queue에 넣었던 노드는 다시 queue에 넣지 않는다.
     */
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.offer(n);
                }
            }
            visit(r);
        }
    }

    /**
     * 재귀함수를 이용한 dfs
     * 일단 node에 방문하면 data를 출력하고 자식들을 순서대로 재귀호출한다.
     * 자식들이 호출을 받으면 자신을 출력하고 자기 자식들을 재귀 호출한다.
     * -> 재귀로 깊이 우선 검색이 가능함.
     */
    void dfsR(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }
    void dfsR(){
        dfsR(0);
    }

    void visit(Node node) {
        System.out.println(node.data + " ");

    }
}
public class BFSandDFS {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        g.dfs();
        g.bfs();
    }
}