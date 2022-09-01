import java.util.Scanner;

class SlidingWindow {
    // 연속된 3일 중에서 최대 매출액 구하기
    // 1. 길이가 3인 창을 하나 만든다 생각하면 된다. -> 그대로 밀고가면 된다. 이중 for문 돌면 O(n^2)가됨.
    // 2. 그대로 밀고 갈 수 있도록. O(n)으로 만들기.
    // 첫 3요소를 sum으로 지정해 놓고, i = 4부터 시작. arr[i] 을 더하고, arr[i-k]를 빼면서 돈다. 그 최댓값을 answer에 저장한다.
     int solution(int n, int k, int[] arr){
        int answer, sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
//            if (sum > answer) answer = sum;
            answer = Math.max(answer, sum);
        }


        return answer;
    }
    public static void main(String[] args) {
        SlidingWindow T = new SlidingWindow();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(n,k,arr));
    }
}
