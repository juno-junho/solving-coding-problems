import java.util.*;

class StackAndQueue6 {

    int solution(int n, int k) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        //list에 넣어준다
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Stack<Integer> stack = new Stack<>();
        // stack에 list 순서대로 하나씩 넣는다. k번째가 되면(stack size == k) list에서 삭제한다., stack도 비우기
        int i = 0;
        while (list.size()!=1){
            stack.push(list.get(i));
            if (stack.size() == k) {
                list.remove(list.get(i));
                stack.removeAllElements();
                if (i > list.size()-1) i = 0;
                continue;
            }
            i++;
            if (i > list.size()-1) i = 0;
        }
        answer = list.get(0);
        return answer;
    }

    // 강사풀이 : Queue 사용
    int solution1(int n, int k) {
        int answer;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int count = 1;
//        while (queue.size() != 1) {
//            if (count == k){
//                count = 1;
//                queue.poll();
//            }
//            queue.offer(queue.poll());
//            count++;
//        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < k; i++) queue.offer(queue.poll());
            queue.poll();
            if (queue.size() == 1) answer = queue.poll();
        }
        answer = queue.poll();
        return answer;

    }
    public static void main(String[] args) {
        StackAndQueue6 T = new StackAndQueue6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }
}
