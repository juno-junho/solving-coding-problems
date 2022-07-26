import java.util.*;

public class FunctionDevelopment {
    static int[] solution3(int[] progresses, int[] speeds) {
        // Queue 자료 구조 이용.
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            int date = (int) Math.ceil((100 -progresses[i]) / (double)speeds[i]);
            // queue가 비어있지 않고 queue 맨위 (기존에 있는 것)이 현재 date 보다 작다면
            if (!queue.isEmpty() && queue.peek() < date){
                answerList.add(queue.size());
                queue.clear();
            }
            queue.offer(date); // queue에 date 추가.
        }
        answerList.add(queue.size());

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day*speeds[i]) < 100) day++;
            dayOfend[day]++; // 100칸 중 끝나는 일자에 index에 ++ 시킴. 7 3 9
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    static int[] solution(int[] progresses, int[] speeds) {

        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) (Math.ceil((100 -progresses[i]) / (double)speeds[i]));
        }
        for (int i = 0; i < days.length; i++) {
            System.out.println("days[" + i + "] :" + days[i] );
        }
        List<Integer> answerList = new ArrayList<>();
        int temp = days[0];
        int count = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > temp) {
                temp = days[i];
                answerList.add(count);
                count = 0;
            }
            if (days[i] <= temp) count ++;
            if (i == days.length-1) answerList.add(count);
        }
        answerList.forEach(System.out::println);
        return answerList.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        solution(new int[]{80}, new int[]{20});
    }
}
