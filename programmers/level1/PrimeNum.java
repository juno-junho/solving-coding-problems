import java.util.*;

public class PrimeNum {
    // 뭐지... 조합.. n개 중에 r개 뽑는 알고리즘.
    // dfs와 백트래킹.

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
        Set<Integer> set = new HashSet<>();

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length ; k++) {
                    set.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        set.forEach(System.out::println);
        long count = set.stream().filter(PrimeNum::isPrime).count();
        return (int)count;

    }
    static boolean isPrime(int num){
        if (num <=1) return false;
        for (int i = 2; i < num ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));

    }
}
