import java.util.*;
// 객체지향으로 푸는것 연습해보기.
class Person {
    static int idNum = 0;
    private int id;
    private int priority;

    public Person(int priority) {
        this.id = idNum++;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}
class StackAndQueue8 {
    // 어떻게 하는데??? 그 최댓값 비교를 어떻게 하는데?
    // 해결 못함.
    int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        // queue 생성
        for (int i : arr) queue.offer(new Person(i));
//        System.out.println(queue);
        int max;
        while (true) {
            max = Integer.MIN_VALUE;
            for (Person person : queue) max = Math.max(max, person.getPriority());
            Person poll = queue.poll();
            // 우선순위가 max이면 poll하고 answer 증가
            if (poll.getPriority() == max) {
                answer++;
                if (poll.getId() == m) break;
            // 아니면 다시 offer
            } else queue.offer(poll);
        }
        return answer;
    }

    int solution1(int n, int m, int[] arr) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int targetNum = arr[m]; // 깂으로 비교 하면 안됨..
        // queue에 값 넣기
        for (int i : arr) queue.offer(i);
        int max = 0;
        for (Integer integer : queue) max = Math.max((max), integer);
        Integer poll = null;
        while (targetNum != poll) {
             poll=queue.poll();
            // 자기보다 위험한 사람 있으면
            for (Integer integer : queue)
                if (integer > poll) {
                    queue.offer(poll);
                } else {
                    // 자기보다 위험한 사람 없으면
                    answer++;
                }
        }
        return answer;
        }


/*        Integer poll = queue.poll();
        // poll이 max이고 targetNum이면 탈출해야한다.
        // poll이 max이고 targetNum이면 false가 되어야한다. a and b
        while (poll != max || poll != targetNum) {
            if (poll == max) {
                answer++;
                max = 0;
                for (Integer integer : queue) max = Math.max((max), integer);
                poll = queue.poll();
            } else {
                queue.offer(poll);
                poll = queue.poll();
            }
        }*/

    public static void main(String[] args) {
        StackAndQueue8 T = new StackAndQueue8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, m, arr));

    }
}
