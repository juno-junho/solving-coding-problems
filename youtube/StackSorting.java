import java.util.Stack;

/**
 * Stack을 정렬하는 함수를 만드시오.
 * (단, 하나의 stack을 추가로 사용할 수 있고, Array 등 다른 데이터 구조는 사용할 수 없음.)

 * // 작은 숫자가 위로 오도록 정렬하기.
 */
class StackSorting {
    private static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();

        while (!s1.isEmpty()) {
            int tmp = s1.pop();
            while (!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }

        // 부어주기
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
       /* Integer poppedValue = s1.pop();

        if (poppedValue < s2.peek()) {
            s1.push(s2.pop());
        }
        s2.push(poppedValue);
        */
    }
}
