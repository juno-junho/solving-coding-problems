import java.util.Arrays;

class InsertionSort1 {

    //내풀이
    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (num < arr[j]) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = num;
        }
    }
    //책풀이
    static void insertionSort1(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > num; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }
    // 또 다른 풀이
    static void insertionSort2(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            int j = i;
            while (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 8, 9};
        int[] arr1 = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        insertionSort1(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
    }

}
