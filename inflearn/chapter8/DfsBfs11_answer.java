import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// bfs를 사용한 풀이법.
// 좌표 사용할때에는 Point 클래스 생각하기.
class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
class DfsBfs11_answer {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] distance;
    static int answer = 0;

    private void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
//        int[] coordinate = {x, y};
        queue.offer(new Point(x, y));
        board[x][y] = 1;    // 출발점 check
        while (!queue.isEmpty()) {
            Point poll = queue.poll();// 꺼낼때 좌표가 나와야 한다.
            x = poll.getX();
            y = poll.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
//                if (nx ==7 && ny == 7) {
//                    distance[nx][ny] = distance[x][y] + 1;
//                    answer = distance[nx][ny];
//                    return;
//                }
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { // 범위 안이고 해당 좌표의 값이 0 일 경우
                    board[nx][ny] = 1;
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        DfsBfs11_answer T = new DfsBfs11_answer();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        distance = new int[8][8];
        T.bfs(1, 1);
        if (distance[7][7] == 0) System.out.println(-1);
        else System.out.println(distance[7][7]);

    }
}