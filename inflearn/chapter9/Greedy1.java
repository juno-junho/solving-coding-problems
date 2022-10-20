import java.util.Scanner;

class Greedy1 {
    /**
     * a 라는 지원자르 다른 모든 지원자와 일대일 비교해서 키와 몸무게가 모두 a 지원자보다 높은 지원자가 존재하면
     * a 지원자는 탈락. 그렇지 않으면 선발.
     *
     * 클래스를 따로 문들어서 클래스 객체 생성해서 키를 기준으로 내림차순 정렬함.
     * 키에 의해서 정렬한 다음 몸무게를 돌면서 O(n)으로 끝낼 수 있다.
     *
     * greedy 알고리즘 : 현재에서 최선의 방법을 선택하는 방법.
     *
     */

    // 내풀이 : O(n^2)
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
