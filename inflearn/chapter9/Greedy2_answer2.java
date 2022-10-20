import java.util.Arrays;
import java.util.Scanner;

class Greedy2_answer2 {
    /**
     * idea : 회의가 끝나는 시간으로 오름차순으로 정렬해서 회의가 빨리끝나는 것 부터 선택한다.
     * 끝나는 시간으로 오름차순 정렬 하되, 끝나는 시간이 같으면 시작 시간을 기준으로 오름차순 또한 해야한다.
     *
     */
    static class Time implements Comparable<Time>{
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Time o) {
            if (o.endTime == this.endTime) return this.startTime - o.startTime; // 오름차순.
            return this.endTime - o.endTime;
        }
    }

    public static void main(String[] args) {
        Greedy2_answer2 T = new Greedy2_answer2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Time[] times = new Time[n];
        for (int i = 0; i < times.length; i++) {
            times[i] = new Time(sc.nextInt(), sc.nextInt());
        }
        System.out.println(T.solution(times, n));
    }

    private int solution(Time[] times, int n) {
        int count = 0;
        Arrays.sort(times);
        for (Time time : times) {
            System.out.println(time.startTime + " : " + time.endTime);
        }
        int et = 0;

        for (Time time : times) {
            if(time.startTime >= et) {
                count++;
                et = time.endTime;
            }
        }
        return count;
    }
}
