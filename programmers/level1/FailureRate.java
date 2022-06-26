import java.util.*;
// 풀이 검토 하기
public class FailureRate {
    static int[] solution(int N, int[] stages) {
        // N수가 result 배열의 크기.
        // 실페율 : 도달했으나 클리어 못한 사람 / 스테이지 도달한 사람
        // 도달했으나 클리어 못한 사람은 stage 배열에서의 수.
        // 스테이지 도달한 사람은 특정 stage >= x의 수.
        Double[] failureRate = new Double[N];
        int[] result = new int[N];
        for (int i = 1; i < N+1; i++) {
            int stageNotCleared = 0;
            int stageReached = 0;
            for (int stage : stages) {
                if (i == stage) stageNotCleared++;
                if (stage >= i) stageReached++;
            }
            if (stageReached !=0) failureRate[i-1] = (double) stageNotCleared / stageReached;
            if (stageReached==0) failureRate[i-1] = 0.0;
        }
        for (Double aDouble : failureRate) {
            System.out.println("failureRate : " + aDouble);
        }
//        Arrays.sort(result, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return failureRate[01];
//            }
//        });

        // 실패율이 담긴 배열을 스테이지로 변환하는 것....
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i < failureRate.length + 1; i++) {
            map.put(i, failureRate[i-1]);
        }
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        keySetList.sort((Comparator) (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        for (int i = 0; i < keySetList.size(); i++) {
            result[i] = keySetList.get(i);
        }

        // 실패율이 같으면... 불가능... 안된다.
//        Arrays.sort(failureRate, Collections.reverseOrder());
//        for (int i = 0; i <N; i++) {
//            for (int j = 1; j < map.size()+1; j++) {
//                // 정렬된 failureRate 값을 map.get()해서 같으면 그 인덱스를 넣기.
//                if (map.get(j).equals(failureRate[i])) result[i] = j;
//            }
//
//        }
        return result;

    }
    public static void main(String[] args) {
        int N = 2;
        int[] stages = {1, 1,1,1,1};
        System.out.println(Arrays.toString(solution(N,stages)));
    }
}
