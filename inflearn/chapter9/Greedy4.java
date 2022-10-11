import java.util.Scanner;

class Greedy4 {

    public static void main(String[] args) {
        Greedy4 T = new Greedy4();
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

    }
}
