import java.util.stream.IntStream;

public class DotProduct {
    public int solution(int[] a, int[] b) {
        // 그냥 for문돌면서 곱한값을 다 더한다..
//        int sum = 0;
//        for (int i = 0; i < a.length ; i++) {
//            sum += (a[i] * b[i]);
//        }
//        return sum;
        // 두번째 방법 stream 이용
       return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();


    }

    public static void main(String[] args) {

    }
}
