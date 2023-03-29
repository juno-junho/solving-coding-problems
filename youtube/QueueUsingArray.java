public class QueueUsingArray {
    /**
     * Array를 사용해서 queue를 구현하는 방법.
     * 자바에서는 뒤에서 (rear)에서 값을 꺼내는 것을 지원 하지 않는다.
     * 일반적으로 제일 앞 / 뒤 (자바는 뒤에서 꺼내는거 지원 x)가 아닌 나머지 원소들의 확인 및 변경은 원칙적으로 불가능하다.

     * 하지만 Node로 Linked List 처럼 구현하는 경우는 last node의 data를 반환하면 되므로 상관 없다..
     *
     */

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
