import java.util.Arrays;
import java.util.Scanner;

class Greedy1_answer2 {

    static class Body implements Comparable<Body> {
        int height;
        int weight;

        Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        // height로 정렬. 음수값을 return 해야함.
        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }

    public int solution(Body[] bodies, int n) {
        int count = 0; // 선발되는 인원수
        Arrays.sort(bodies);
        int max = Integer.MIN_VALUE;
        for (Body body : bodies) {
            if (body.weight > max) {
                count++;
                max = body.weight;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Greedy1_answer2 T = new Greedy1_answer2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Body[] bodies = new Body[n];
        for (int i = 0; i < bodies.length; i++) {
            bodies[i] = new Body(sc.nextInt(), sc.nextInt());
        }
        System.out.println(T.solution(bodies, n));
    }
}
