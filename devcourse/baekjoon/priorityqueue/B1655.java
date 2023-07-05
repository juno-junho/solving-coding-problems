package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1655 {
    private static String solution(int[] numbers) {
        var minQueue = new PriorityQueue<Integer>();
        var maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            // size가 같으면 maxqueue에 넣어준다
            if (maxQueue.size() == minQueue.size()) {
                maxQueue.add(numbers[i]);
                // 그런데 minqueue에 값이 있고 maxqueue의 값이 더 크다면 값을 바꿔준다
                if (!minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(minQueue.poll());
                }
            } else {
                // size가 다르면 minqueue에 넣어준다
                minQueue.add(numbers[i]);
                // 값 바꿔주기
                if (maxQueue.peek() > minQueue.peek()) {
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(minQueue.poll());
                }
            }
            sb.append(maxQueue.peek()).append("\n");
        }
        return sb.toString();
    }

    // 틀린풀이
    /*
    for (int number : numbers) {
            if (count % 2 == 0) {
                maxQueue.add(number);
                System.out.println(maxQueue.peek());
            } else {
                minQueue.add(number);
                Integer value = maxQueue.peek() >= minQueue.peek() ? minQueue.peek() : maxQueue.peek();
                System.out.println(value);
            }
            count++;
        }
     */
    // 시간 초과
  /*for (int number : numbers) {
        priorityQueue.add(number);
        count++;
        // 여기서 중간값을 출력해줘야함
        var clone = new PriorityQueue<>(priorityQueue);
        int index = (count - 1) / 2;
        for (int i = 0; i < index; i++) {
            clone.poll();
        }
        System.out.println(clone.poll());
    }*/


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(solution(numbers));
    }
}
