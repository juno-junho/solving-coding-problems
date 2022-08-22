import java.util.Arrays;

public class HIndex {
    static int solution(int[] citations) {
        // 최댓값을 구한다
        // 최댓값 만큼 돌면서, (역순) 최댓값을 구하기 위해서
        // i와 i보다 큰 개수 count가 일치하면 i를 return
        int maxNum = Arrays.stream(citations).max().getAsInt();
        for (int i = maxNum; i >= 0; i--) {
            int finalI = i;
            long count = Arrays.stream(citations).filter(j -> j >= finalI).count();
            if (i <= count && (citations.length-count <= i) ) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        //[1,4] -> 1
        //[0,1,2] -> 1
        System.out.println(solution(new int[]{1,4}));

    }
}
