import java.util.*;

// bfs를 사용한 풀이법.
// distance 배열을 이용해서 이동 거리를 계산할 생각을 못했다.

class DfsBfs11 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] distance;
    static int answer = 0;

    private void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] coordinate = {x, y};
        queue.offer(coordinate);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();// 꺼낼때 좌표가 나와야 한다.
            x = poll[0];
            y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx ==7 && ny == 7) {
                    distance[nx][ny] = distance[x][y] + 1;
                    answer = distance[nx][ny];
                    return;
                }
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { // 범위 안이고 해당 좌표의 값이 0 일 경우
                    board[nx][ny] = 1;
                    distance[nx][ny] = distance[x][y] + 1;
                    coordinate = new int[]{nx, ny};
                    queue.offer(coordinate);
                }
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs11 T = new DfsBfs11();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        distance = new int[8][8];
        board[1][1] = 1;    // 출발점 check
        T.bfs(1, 1);
        System.out.println(answer);

    }
}