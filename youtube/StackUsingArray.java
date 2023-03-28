import java.util.EmptyStackException;

public class StackUsingArray {

    private final int[] dat;
    private int pos = 0;

    public StackUsingArray() {
        this.dat = new int[100000];
    }

    public void push(int x) {
        dat[pos++] = x;
    }

    public int pop() {
        if (pos == 0) {
            throw new EmptyStackException();
        }
        // 굳이 data가 있으면 안지워도 된다. pos만 한칸 아래로 이동시켜주면된다.
    /*    int tem = dat[pos - 1];
        dat[--pos] = 0;
        return tem;*/
        return dat[--pos];
    }

    public int peek() {
        if (pos == 0) {
            throw new EmptyStackException();
        }
        return dat[pos - 1];
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
