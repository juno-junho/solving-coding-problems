
import java.util.stream.IntStream;
//다른 풀이 공부하기
public class Pocketmon {

    static int solution(int[] nums) {
        // nums/2 수를 고르는데, 그 중 종류를 많이 뽑을 수 있는 수.
        // 방법 1. 일단 nums/2 만큼 뽑는데, nums를 set으로 만들어 contains 해서 count++해주는 방법.
        // 방법 2. distinct()로 중복 없앤다음 그 중 nums.length /2 만큼 뽑기.
        long count = IntStream.of(nums).distinct().count();
        if (nums.length / 2 > count) return (int) count;
        else return (nums.length/2);

//        set.forEach(System.out::println);
//        Arrays.asList(nums).forEach(System.out::println);

    }
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));


    }
}
