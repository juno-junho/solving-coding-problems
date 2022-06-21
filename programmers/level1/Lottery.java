import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Lottery {
    // 배울것 : boxed() stream, stream 풀이법, 일반 풀이법. .
    // int 배열을 Integer type list로 바꾸는 법 : 1. 반복문으로 하나하나 넣어주기. 2. stream.box()
    // 1등은 0을 그냥 일치하는걸로 치는거
    // 최저 순위는 0을 모두 일치하지 않는걸로 치는 거.
    // 그런데 두 배열을 비교. 어떻게 할것이냐. set이나 list로 만들어 contains 메소드?
    // 아니면 정렬한 다음 일일히 비교? 문제는 0을 제외하고 lottos 배열과 win_nums 배열을 비교해야 하는 것.
    public int[] solution(int[] lottos, int[] win_nums) {
        // 정석 풀이
        int zero = 0;
        int matched = 0;
        for (int lotto : lottos) {
            if (lotto == 0){
                zero++;
                continue;
            }
            for (int win_num : win_nums) {
                if (win_num == lotto) matched++;
            }
        }

        return new int[]{ Math.max(7 - (zero + matched), 6), Math.max(7 -  matched, 6)};



    // 방법 1.
        /*List<Integer> my_num = Arrays.stream(lottos).filter(i -> i != 0).boxed().collect(Collectors.toList());
        long zeroCount = Arrays.stream(lottos).filter(i -> i == 0).count();
        int minCount = 0;
        for (int win_num : win_nums) {
            if(my_num.contains(win_num)) minCount++;
        }
        int maxCount = (int) (minCount + zeroCount);
        int result1 = 7-maxCount;
        int result2 = 7-minCount;
        if (result1 > 6) result1 = 6;
        if (result2 > 6) result2 = 6;

        int[] answers = {result1,result2};
        return answers;
         */
//        int[] counts = {maxCount,minCount};
//        List<Integer> resultList = new ArrayList<>();
//        for (int count : counts) {
//            int rank;
//            switch (count){
//                case 6 : rank = 1;
//                        break;
//                case 5 : rank = 2;
//                        break;
//                case 4 : rank = 3;
//                        break;
//                case 3 : rank = 4;
//                        break;
//                case 2 : rank = 5;
//                        break;
//                default: rank = 6;
//            }
//            resultList.add(rank);
//        }
//
//        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
    //stream 풀이법.
/*
    public int[] solution(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
*/
    public static void main(String[] args) {

    }
}
