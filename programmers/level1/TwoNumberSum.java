import java.util.*;
import java.util.stream.IntStream;

public class TwoNumberSum {
    // 두 개 뽑아서 더하기
     static int[] solution(int[] numbers) {
        // 가장 기본 적이고, 직관적으로 눈에 보이는 방법 :
         // brute force로 numbers 하나하나 돌면서 set하나 만들어서 집어 넣기.
         // set을 list로 만들어서 foreach로 출력.
         Set<Integer> numSet = new HashSet<>();
         //1. 이중 for문
         for (int i = 0; i < numbers.length ; i++) {
             for (int j = 0; j < i ; j++) {
                 numSet.add(numbers[i] + numbers[j]);
             }
         }
         // 2. stream으로.
//         IntStream.of(numbers).forEach((a,b) -> numSet.add(a+b));
         return numSet.stream().sorted().mapToInt(Integer::intValue).toArray();
//         return Arrays.stream(new ArrayList<Integer>(numSet).toArray()).mapToInt(value -> (Integer)value).sorted().toArray();
     }

    public static void main(String[] args) {
         int[] numbers = {5,0,2,7};
        System.out.println(Arrays.toString(solution(numbers)));

    }
}

