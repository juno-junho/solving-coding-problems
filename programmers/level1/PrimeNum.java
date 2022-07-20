import java.util.*;

public class PrimeNum {
    // 뭐지... 조합.. n개 중에 r개 뽑는 알고리즘.
    // dfs와 백트래킹.
     int solution(int[] nums) {

        // 서로 다른것 뽑는다. -> nums 두개 더하기 -> 3중 for문 개오바
//        int[] newArr = new int[nums.length*2];
//        System.arraycopy(nums,0,newArr,0,nums.length);
//        System.arraycopy(nums,0,newArr,nums.length,nums.length);
//        // 1 2 3 4 1 2 3 4
//
//        for (int i = 0; i < nums.length; i++) {
//            if(isPrime(newArr[i] + newArr[i+1] + newArr[i+2])) result ++;
//        }
//        Set<Integer> set = new HashSet<>();
//
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                for (int k = j+1; k < nums.length ; k++) {
//                    set.add(nums[i] + nums[j] + nums[k]);
//                }
//            }
//        }
//        set.forEach(System.out::println);
//        long count = set.stream().filter(PrimeNum::isPrime).count();
//        return (int)count;

        // nums에서 3가지 수를 추출. 조합.
        // 방법 : 일단 처음 index를 0 0 0 으로 세팅.
        // 맨 뒤 인덱스가 arr.length-1의 index(끝)에 도착하면 두번째 인덱스 한칸 올리고 그다음으로 세번째 인덱스 세팅

        int index1 = 0, index2 = 1, index3 = 2;
        int count = 0;
        while (index1 != nums.length-2){
            if(isPrime(nums[index1] + nums[index2] + nums[index3])) count++;
            if (index2 == nums.length-2) {
                index1++;
                index2 = index1 + 1;
                index3 = index2 + 1;
                continue;
            }
            if(index3 == nums.length-1) {
                index2++;
                index3 = index2 + 1;
                continue;
            }

            index3 ++;
        }

        return count;

    }
    private boolean isPrime(int num){
        if (num <=1) return false;
        for (int i = 2; i < num ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
//        System.out.println(solution(nums));

    }
}
