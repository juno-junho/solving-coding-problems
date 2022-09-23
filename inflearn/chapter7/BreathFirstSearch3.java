import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreathFirstSearch3 {

    static boolean[] ch;
    static int num;
    static int[][] a;
    void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        ch[start] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.println("x = " + x);
            for (int i = 0; i < a[x].length; i++) {
                int y = a[x][i];
                System.out.println("y = " + y);
                if (!ch[y]) {   // 방문한적 없으면 queue에 넣기.
                    queue.offer(y);
                    ch[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        ch = new boolean[num + 1];
        a = new int[num + 1][num + 1];
        // 1과 2를 연결합니다
        a[1][2] = 1;
        a[2][1] = 1;
        // 1과 3를 연결합니다
        a[1][3] = 1;
        a[3][1] = 1;
        // 2과 4를 연결합니다
        a[2][4] = 1;
        a[4][2] = 1;
        // 2과 5를 연결합니다
        a[2][5] = 1;
        a[5][2] = 1;
        // 3과 6를 연결합니다
        a[3][6] = 1;
        a[6][3] = 1;
        // 3과 7를 연결합니다
        a[3][7] = 1;
        a[7][3] = 1;
        BreathFirstSearch3 bf3 = new BreathFirstSearch3();
        bf3.bfs(1);




    }

}
