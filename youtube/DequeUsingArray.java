import java.util.NoSuchElementException;

public class DequeUsingArray {

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
