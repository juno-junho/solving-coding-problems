import java.util.Arrays;

public class KthNumber {
    static int[] solution(int[] array, int[][] commands) {
        //stream 이용. or Arrays.copyOfRange()사용 가능.
        int[] answer = new int[commands.length];
//        for (int i = 0; i < commands.length; i++) {
//            int[] ints = Arrays.stream(array, commands[i][0] - 1, commands[i][1]).sorted().toArray();
//            answer[i] = ints[commands[i][2]-1];
//        }
//        for (int i = 0; i < commands.length; i++) {
//            //array 자르기
//            array
//        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3,4,5},
                {2,3,4,5,6},
                {2,3,4,5,2}
        };
        System.out.println(a[0].length);
    }
}
