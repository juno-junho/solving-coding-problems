import java.util.Scanner;

class Greedy1 {

    public static void main(String[] args) {
        Greedy1 T = new Greedy1();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        T.solution(n, height, weight);
    }

    private void solution(int n, int[] height, int[] weight) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int targetHeight = height[i];
            int targetWeight = weight[i];
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (targetHeight < height[j] && targetWeight < weight[j]){
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}
