import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 강사 풀이 (queue를 밖으로 빼서 scanner로 입력과 동시에 받음)
//
class DfsBfs12_answer {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] storage;
    static int[][] distance;
    static int m;
    static int n;
    static Queue<Point> queue = new LinkedList<>();
    private int bfs() {
        // bfs 돌기
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.getX() + dx[i];
                int ny = temp.getY() + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && storage[nx][ny] == 0) {
                    storage[nx][ny] = 1;
                    distance[nx][ny] = distance[temp.getX()][temp.getY()] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        // 돌고 난 후 0이 있는지 체크. 있으면 -1 반환.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 0) return -1;
            }
        }
        // 돌고 난 후 0이 없을때, distance의 최대값 반환.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(distance[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        DfsBfs12_answer T = new DfsBfs12_answer();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        storage = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                storage[i][j] = sc.nextInt();
                if(storage[i][j] == 1) queue.offer(new Point(i, j));
            }
        }
        System.out.println(T.bfs());
    }
}
