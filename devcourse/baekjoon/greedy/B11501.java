package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11501 {
    /**
     * 틀림.
     * idea: 뒤에서 부터 돌자.. 시간 초과
     * 그리고 범위 long으로 해야한다.
     */
    private static long solution(long[] stocks) {
        long result = 0;
        long max = Integer.MIN_VALUE;
        for (long stock : stocks) {
            max = Math.max(stock, max);
        }
        List<Long> boughtStocks = new ArrayList<>();
        for (int i = 0; i < stocks.length; i++) {
            //1. 자기 이후 최댓값될때 까지 계속 산다..
            // 최댓값이면 판다.
            if (max == stocks[i]) {
                for (Long boughtStock : boughtStocks) {
                    result += stocks[i] - boughtStock;
                }
                boughtStocks.clear();
                max = Long.MIN_VALUE;
                for (int j = i + 1; j < stocks.length; j++) {
                    max = Math.max(max, stocks[j]);
                }
            } else { // 아니면 산다.
                boughtStocks.add(stocks[i]);
            }
        }
        return result;
    }
/*
    private static long solution(long[] stocks) {
        long result = 0;
        long max = 0;
        for (int i = stocks.length - 1; i >= 0; i--) {
            if (stocks[i] > max) {
                max = stocks[i];
            } else {
                result += max - stocks[i];
            }
        }
        return result;
    }
*/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int days = Integer.parseInt(bufferedReader.readLine());
            long[] stocks = new long[days];
            String stockStr = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(stockStr);
            for (int j = 0; j < stocks.length; j++) {
                stocks[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            sb.append(solution(stocks)).append("\n");
        }
        System.out.println(sb);

    }
}
