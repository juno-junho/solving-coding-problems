import java.util.Scanner;

class Graph1 {
    /**
     * 경로탐색 (인접행렬)
     * 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요
     * (정점 수 n 과 간선수 m이 주어진다. graph에서 경로는 한번 방문한 node는 다시 방문하면 안된다.
     */
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void dfs(int v) {
        if (v==n) answer++;
        else{
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        Graph1 T = new Graph1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // node의 개수
        m = sc.nextInt();   // 간선의 개수
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
