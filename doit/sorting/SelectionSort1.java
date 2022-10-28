
import java.util.Arrays;

// 가장 작은 값을 처음으로 보내는 방법.
class SelectionSort1  {

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 8, 9};
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
