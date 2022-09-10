import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    ArrayList<Integer> solution(int n, int k, int[] arr) {
        // rt의 index는 rt + k - 1부터 시작.
        // value가 0이면 지우는것 명심하기.
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> HM = new HashMap<>();
        // k - 1 전까지 넣어두고
        for (int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }
        // rt는 k - 1 부터 시작
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt]) - 1);
            if (HM.get(arr[lt]) == 0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (Integer i : T.solution(n, k, arr)) {
            System.out.print(i + " ");
        }
    }
}
