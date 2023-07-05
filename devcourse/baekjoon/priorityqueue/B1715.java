package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
    private static int solution(int[] cards) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int card : cards) {
            priorityQueue.add(card);
        }
        // 처음 낮은 수 2개 poll -> 하나씩 작은 수 부터 poll 하면서 더해 나간다
        int answer = 0;
        while (priorityQueue.size() > 1) {
            int initialValue = priorityQueue.poll() + priorityQueue.poll();
            answer += initialValue;
            priorityQueue.add(initialValue);

        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(solution(cards));
    }
}
