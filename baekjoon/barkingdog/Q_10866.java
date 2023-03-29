import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q_10866 {
    /**
     * Deque 구현
     */

    static class DequeUsingArray {

        private final int max = 10000;
        private final int[] dat;

        private int head = max;
        private int tail = max+1;

        public DequeUsingArray() {
            this.dat = new int[2 * max];
        }

        boolean isEmpty() {
            return tail - head == 1;
        }

        void pushFromFront(int data) {
            dat[head--] = data;
        }

        void pushFromBack(int data) {
            dat[tail++] = data;
        }

        int popFromFront() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return dat[++head];
        }

        int popFromBack() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return dat[--tail];
        }

        int front() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return dat[head + 1];
        }

        int back() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return dat[tail - 1];
        }

        public int size() {
            if (isEmpty()) {
                return 0;
            }
            return tail - head - 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        DequeUsingArray deque = new DequeUsingArray();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "push_front":
                    deque.pushFromFront(sc.nextInt());
                    break;
                case "push_back":
                    deque.pushFromBack(sc.nextInt());
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.popFromFront()).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.popFromBack()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.front()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.back()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
