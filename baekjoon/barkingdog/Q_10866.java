import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q_10866 {
    /**
     * Deque 구현 및 자바의 deque

     * 자바에서 deque는 rrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 등의 클래스로 구현한다.
     *
     * addFirst / offerFirst : 맨 앞에 추가
     * addLast / offerLast == add : 맨 뒤에 추가
     * removeFirst == remove / pollFirst == poll : 맨 앞 요소 제거
     * removeLast / pollLast : 맨 뒤 요소 제거
     * getFirst / peekFirst  == peek: 맨 앞 요소 반환
     * getLast / peekLast : 맨 뒤 요소 반환
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

//        DequeUsingArray deque = new DequeUsingArray();

        Deque<Integer> dequeUsingJava = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "push_front":
//                    deque.pushFromFront(sc.nextInt());
                    dequeUsingJava.addFirst(sc.nextInt());
                    break;
                case "push_back":
//                    deque.pushFromBack(sc.nextInt());
                    dequeUsingJava.addLast(sc.nextInt());
                    break;
                case "pop_front":
//                    if (deque.isEmpty()) {
                    if (dequeUsingJava.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
//                        sb.append(deque.popFromFront()).append("\n");
                        sb.append(dequeUsingJava.removeFirst()).append("\n");
                    }
                    break;
                case "pop_back":
//                    if (deque.isEmpty()) {
                    if (dequeUsingJava.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
//                        sb.append(deque.popFromBack()).append("\n");
                        sb.append(dequeUsingJava.removeLast()).append("\n");
                    }
                    break;
                case "size":
//                    sb.append(deque.size()).append("\n");
                    sb.append(dequeUsingJava.size()).append("\n");
                    break;
                case "empty":
//                    if (deque.isEmpty()) {
                    if (dequeUsingJava.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
//                    if (deque.isEmpty()) {
                    if (dequeUsingJava.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
//                        sb.append(deque.front()).append("\n");
                        sb.append(dequeUsingJava.peekFirst()).append("\n");
                    }
                    break;
                case "back":
//                    if (deque.isEmpty()) {
                    if (dequeUsingJava.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
//                        sb.append(deque.back()).append("\n");
                        sb.append(dequeUsingJava.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
