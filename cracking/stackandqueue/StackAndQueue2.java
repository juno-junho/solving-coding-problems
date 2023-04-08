package stackandqueue;

public class StackAndQueue2<T> extends StackImpl<T> {
    /**
     * 나는 top node를 linked list 돌듯 돌면 된다 생각 -> but 시간복잡도 : O(N)
     * o(1)로 줄일 수 있는 방법을 모르겠다
     * <p>
     * 정답 )
     * Stack class의 멤버 변수로 min value를 두는것.
     * push와 삭제할 때마다 확인.
     */

    static class NodeWithMin {
        public int value;
        public int min;

        NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push((T) new NodeWithMin(value, newMin));
    }

    @Override
    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE; // 에러값
        }
//        return peek().min;
        return 0;
    }
}
