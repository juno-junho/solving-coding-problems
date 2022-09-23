import java.util.ArrayList;
import java.util.Scanner;

class Graph2 {
    /**
     * 경로탐색 (인접리스트)
     * 인접 행렬 (이차원 배열)을 사용하면 n수가 커지면 너무 비효율 적이다.
     * memory 낭비도 심하고, 갈수 있는 정점 찾으려면 n번만큼 다 돌아야 한다. 그래서 각 노드마다 List로 만들어서
     * 해당 노드(정점)에서 갈 수 있는 노드들을 각 list에 추가한다.
     * -> 나중 탐색할때 인접행렬처럼 n 까지 돌 필요없이 바로 조회가능.
     */
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void dfs(int v) {
        if (v == n) answer++;
        else {
            // graph.get(v) 하면 해당 노드에서 갈 수 있는 노드들이 나옴.
            for (Integer nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dfs(nv);
                    ch[nv] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph2 T = new Graph2();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // node의 개수
        m = sc.nextInt();   // 간선의 개수
        graph = new ArrayList<ArrayList<Integer>>();
        // 객체 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // check 배열
        ch = new int[n + 1];
        // 시작 node arrayList에 접근해서 도착 node 추가하기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
