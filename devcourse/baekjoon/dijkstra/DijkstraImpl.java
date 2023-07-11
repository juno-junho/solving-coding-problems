package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraImpl {

    static ArrayList<Node>[] graph;

    public static void Dijkstra(int n, int start) {
        boolean[] check = new boolean[n + 1]; // TODO 정점을 방문했는지 확인
        int[] dist = new int[n + 1];    // TODO 출발지로 부터 거리가 얼마나 되는지 기록.

        int INF = Integer.MAX_VALUE;    // TODO 무한대로 초기화
        Arrays.fill(dist, INF);

        dist[start] = 0;    // todo 출발지는 방문으로 표시, dist 배열 해당 인덱스에 0 기록
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));    // TODO 출발지 정점과 가중치를 우선순위 큐에 넣는다.

        while (!priorityQueue.isEmpty()) {
            int nowVertex = priorityQueue.poll().index;
            if (check[nowVertex]) {
                continue;
            }
            // todo 방문 체크
            check[nowVertex] = true;

            for (Node next : graph[nowVertex]) {    // todo arraylist돌면서 index의 연결된 정점 비교
                if (dist[next.index] > dist[nowVertex] + next.cost) { // todo 거리 비교
                    dist[next.index] = dist[nowVertex] + next.cost;

                    priorityQueue.offer(new Node(next.index, dist[next.index]));
                }
            }

            // todo 최소 거리 출력
            for (int i : dist) {
                if (i == INF) {
                    System.out.println(0 + " ");
                } else {
                    System.out.println(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // todo 그래프 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        int start = Integer.parseInt(bf.readLine());

        Dijkstra(n, start);
    }

}

class Node implements Comparable<Node> {

    int index;  // 인덱스
    int cost;   // 가중치

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    /**
     * 가중치를 기준으로 비교
     */
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
