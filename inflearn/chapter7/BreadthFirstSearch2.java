import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BreadthFirstSearch2 {
    
    // bfs 사용하지 않은 내풀이
    private int solution(int s, int e) {
        // 뒤로는 1 앞으로는 1 or 5
        // 송아지가 뒤에 있을때
        int distance = s - e;
        if(distance <=0) return distance;
        // 송아지가 앞에 있을때
        if (distance % 5 >= 3) {
            return (5 - distance % 5) + (distance / 5 + 1);
        }
        return (distance / 5) + (distance % 5);
    }

    // 강사풀이
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> queue = new LinkedList<>();

    private int bfs(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int j : dis) {
                    int nx = x + j;
                    if (x == e) return L + 1;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        BreadthFirstSearch2 T = new BreadthFirstSearch2();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.bfs(s,e));
    }
}