import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {
    public String solution(int[] numbers) {
//        // numbers에서 가장 큰 수. (가장
//        Arrays.sort(numbers, new Comparator<Integer>() {
//            @Override
//            public int compare(int o1, int o2) {
//                return (o1-o2);
//            }
//        });

        int[] maxNum = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] > 10) {
                numbers[i] /= 10;
            }
            maxNum[i]= numbers[i];
        }
        Arrays.sort(maxNum);
        StringBuilder sb = new StringBuilder();
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {

    }
}
