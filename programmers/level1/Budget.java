import java.util.Arrays;

public class Budget {
    // 최대 얼마까지 지원 가능하냐...
    // int 배열 d에서 sort 한 다음에 젤 작은것 부터 돌면서 budget에서 빼주고, 크면 result return하면 됨.
    static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int department : d) {
            if (budget - department < 0) break;
            budget -= department;
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(solution(d,budget));
    }
}
