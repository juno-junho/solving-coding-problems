import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph3 {
    /**
        그래프 최단거리dfsf
     */
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer nv : graph.get(current)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[current] + 1;
                }// 방문했냐 안했냐
            }
        }

    }

    public static void main(String[] args) {
        Graph3 T = new Graph3();
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
        dis = new int[n + 1];
        // 시작 node arrayList에 접근해서 도착 node 추가하기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println("dis[i] = " + dis[i]);
        }
    }
}
