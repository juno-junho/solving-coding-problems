import java.util.Scanner;

/**
 * queue 구현
 */
public class Q_10845 {

     static class Queue {

        private final int[] dat;
        private int head = 0;
        private int tail = 0;

        public Queue() {
            this.dat = new int[10000];

        }

        void push(int x) {
            dat[tail++] = x;
        }

        int pop() {
            return dat[head++];
        }

        int front() {
            return dat[head];
        }

        int back() {
            return dat[tail - 1];
        }

        boolean isEmpty() {
            return head == tail;
        }

        int size() {
            return tail - head;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Queue queue = new Queue();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "push":
                    int value = sc.nextInt();
                    queue.push(value);
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.front()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.back()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.pop()).append("\n");
                    }
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
