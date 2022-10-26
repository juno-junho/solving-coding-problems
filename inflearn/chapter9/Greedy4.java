import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Greedy4 {
    /**
     * 내 풀이 : 일단 강연료로 내림차순 정렬한다. 강연료 같으면 day로는 오름차순한다.
     * 그리고 하나씩 돌면서 priorityQueue에 넣고, PriorityQueue는 day로 오름차순.
     * 그것의 최댓값을 구하기.
     * 60 3
     * 50 2
     * 40 1
     * 30 1
     * 30 3
     * 20 1
     */
    static class Lecture implements Comparable<Lecture>{
        int price;
        int day;

        public Lecture(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.price - this.price;    // 내림차순
        }
    }
    public static void main(String[] args) {
        Greedy4 T = new Greedy4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            lectures[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }
        System.out.println(T.solution(lectures, n));
    }

    private int solution(Lecture[] lectures, int n) {
        Arrays.sort(lectures);
        return 0;
    }
}
