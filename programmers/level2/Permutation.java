import java.util.Arrays;

public class Permutation {
    private static int num;
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8};

        perm(arr, 0);
    }
    public static void perm(int[] arr, int depth) {
        if (depth == arr.length) {
            System.out.println(Arrays.toString(arr));
            num++;
            System.out.println(num);
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            perm(arr, depth + 1);
            swap(arr, depth, i);
        }
    }
    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
//    public static void print(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1)
//                System.out.println(arr[i]);
//            else
//                System.out.print(arr[i] + ",");
//        }
//    }
}
