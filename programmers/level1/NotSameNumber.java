import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NotSameNumber {
    // stack과 queue에 대한 정리.
    static int[] solution(int []arr) {
        // 배열 arr는 0~9까지 이루어져 있따. arr에서 연속적으로 나타나는 숫자 하나만 남기고 전부 제거.
//        Stack<Integer> stack = new Stack<>();
//        for (int i : arr) {
//            if (stack.isEmpty()) {
//                stack.push(i);
//                continue;
//            }
//            if (stack.peek() != i) stack.push(i);
//
//        }
//
//        return stack.stream().mapToInt(Integer::valueOf).toArray();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = arr[0];
        for(int num : arr) {
            if (tempList.isEmpty()){
                tempList.add(num);
                continue;
            }
            if(preNum != num) tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
      int[] arr = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
