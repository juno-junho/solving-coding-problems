import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrimeNum {
    static int solution(int[] nums) {
        // 서로 다른것 뽑는다. -> nums 두개 더하기 -> 3중 for문 개오바
//        int[] newArr = new int[nums.length*2];
//        System.arraycopy(nums,0,newArr,0,nums.length);
//        System.arraycopy(nums,0,newArr,nums.length,nums.length);
//        // 1 2 3 4 1 2 3 4
//
//        for (int i = 0; i < nums.length; i++) {
//            if(isPrime(newArr[i] + newArr[i+1] + newArr[i+2])) result ++;
//        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length ; k++) {
                    if(isPrime(nums[i] + nums[j] + nums[k])) result ++;
                }
            }
        }
        return result;

    }
    static boolean isPrime(int num){
        if (num <=1) return false;
        for (int i = 2; i < num ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));

    }
}
