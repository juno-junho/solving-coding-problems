import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 8번 문제에 대한 강사 풀이.
class Answer {
    class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }
    }
    int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.offer(new Person(i, arr[i]));
        while (!queue.isEmpty()) {
            // 첫번째 사람 꺼내서
            Person temp = queue.poll();
            for (Person person : queue) {
                if (person.priority > temp.priority) {
                    queue.offer(temp);
                    temp = null;
                    break;
                }
            }
            // 자기보다 우선순위 높은 사람이 없을 경우
            if (temp != null) {
                answer++;
                if (temp.getId() == m) return answer;
            }
        }
        return answer;
    }

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
