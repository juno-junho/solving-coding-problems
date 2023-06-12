package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2217 {
    /**
     * k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼 중량이 걸리게 된다.
     * 로프들에 대한 정보가 주어졌을대 들어올릴 수 있는 물체의 최대 중량은?
     * ---/
     * 각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오.
     * 모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.
     */

    // O(NlogN)
    private static int solution(int n, int[] maxWeight) {
        Arrays.sort(maxWeight);
        int maxTotalWeight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int totalWeight = maxWeight[i] * (n - i);
            maxTotalWeight = Math.max(maxTotalWeight, totalWeight);
        }
        return maxTotalWeight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] maxWeight = new int[N];
        for (int i = 0; i < N; i++) {
            maxWeight[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(solution(N, maxWeight));
    }
}
