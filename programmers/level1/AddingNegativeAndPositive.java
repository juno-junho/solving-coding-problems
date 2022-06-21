import java.util.HashMap;
import java.util.Map;

public class AddingNegativeAndPositive {
    // 와... result += absolutes[i] * (signs[i]? 1: -1);
    static int solution(int[] absolutes, boolean[] signs) {
        // 방법 1. 그냥 for문 돌자.. -> 2중..
        // hashmap
        int result = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) result+= absolutes[i];
            else result -= absolutes[i];
        }
        System.out.println(result);
        return result;
        //방법 2. hashmap
//        Map<Integer,Boolean> numbers = new HashMap<>();
//        for (int i = 0; i <  absolutes.length; i++) {
//            numbers.put(absolutes[i],signs[i]);
//        }
//       int[] sum = {0}; // ?
//        numbers.forEach((k,v) ->{
//            if (v) sum[0] += k;
//            else sum[0] -= k;
//        });
//        System.out.println(sum[0]);
//        return sum[0];
    }
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true,false,true};
        solution(absolutes,signs);
    }
}
