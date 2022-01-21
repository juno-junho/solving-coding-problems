import java.util.Scanner;
import java.util.stream.IntStream;

public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        //Arrays.setAll(arr, i -> sc.nextInt());
        //int[] arr = IntStream.range(0, 9).map(i -> sc.nextInt()).toArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (a > max) {
                max = a;
                index = i+1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}

