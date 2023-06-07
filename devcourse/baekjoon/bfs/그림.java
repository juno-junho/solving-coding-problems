package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class 그림 {
    static int[] dx = {-1, 0, 1, 0}; // 시계방향
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;

    private void bfs(int x, int y) {
        int area = 0;
        int count = 0;
        Queue<Point1> queue = new LinkedList<>();
        queue.offer(new Point1(x, y));
        board[x][y] = 1;
        while (!queue.isEmpty()) {
            Point1 poll = queue.poll();
            x = poll.getX();
            y = poll.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= board.length - 1 && ny >= 1 && ny <= board[0].length - 1 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point1(nx, ny));

                }
            }
        }
    }

    public static void main(String[] args) {
        그림 paint = new 그림();
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        board = new int[row + 1][col + 1];// -> 메모리를 2개 추가하기. 테두리 처리

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[row + 1][col + 1];
        paint.bfs(1, 1);
    }
}

class Point1 {
    private int x;
    private int y;

    public Point1(int x, int y) {
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


