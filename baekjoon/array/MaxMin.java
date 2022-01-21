import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        // 1. stream
//        int max = Arrays.stream(array).max().getAsInt();
//        int min = Arrays.stream(array).min().getAsInt();
//        System.out.println(min);
//        System.out.println(max);
            //2. for문
            int max = array[0];
            int min = array[0];
            for (int j : array) {
                if (j > max) {
                    max = j;
                }
                if (j < min) {
                    min = j;
                }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
