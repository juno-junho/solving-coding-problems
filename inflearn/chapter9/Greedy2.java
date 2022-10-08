import java.util.Scanner;

class Greedy2 {

    public static void main(String[] args) {
        Greedy2 T = new Greedy2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = sc.nextInt();
            endTime[i] = sc.nextInt();
        }
        T.solution(n, startTime, endTime);
    }

    private void solution(int n, int[] startTime, int[] endTime) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = recursion(n, i, startTime, endTime, 0);
            System.out.println(i + " : " + sum);
            if (sum >= answer) answer = sum;
        }
        System.out.println(answer);
    }

    private int recursion(int n, int index, int[] startTime, int[] endTime, int sum) {
        int end = endTime[index];
        for (int i = 0; i < n; i++) {
            if (index == i) continue;
            if (startTime[i] >= end) {
                sum++;
                recursion(n, i, startTime, endTime, sum);
            }
        }
        return sum;
    }
}
