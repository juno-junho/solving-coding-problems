import java.util.Scanner;

class Greedy3 {

    public static void main(String[] args) {
        Greedy3 T = new Greedy3();
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
        int[] num = new int[72];
        for (int i = 0; i <= 72; i++) {
            for (int j = 0; j < n; j++) {
                if (startTime[j] <= i && endTime[j] > i) num[i]++;
            }
        }
        int answer = 0;
        for (int max : num) {
            if (answer < max) answer = max;
        }
        System.out.println(answer);
    }

}
