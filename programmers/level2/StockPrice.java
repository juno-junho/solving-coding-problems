import java.util.Stack;

public class StockPrice {
    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        stack.push(i);

        for (i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int beginIndex = stack.pop();
                answer[beginIndex] = i - beginIndex;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int beginIndex = stack.pop();
            answer[beginIndex] = i - beginIndex - 1;
        }
        return answer;
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;

        for (int i = 0; i < prices.length -1; i++) {

            for (int j = i+1; j < prices.length ; j++) {
                count++;
                if (prices[i]> prices[j]){
                    break;
                }
            }
            answer[i] = count;
            count = 0;

        }
        answer[prices.length-1] = 0;

        return answer;
    }
}
