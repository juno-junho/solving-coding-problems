public class QueueUsingArray {

    private final int[] dat;
    private int head = 0;
    private int tail = 0;

    public QueueUsingArray() {
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



}
