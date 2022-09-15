import java.util.Scanner;

class SortingAndSearching3 {

    // 강사풀이와 내풀이가 같음.
     int[] insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (num < arr[j]) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = num;
        }
         return arr;
    }

    public static void main(String[] args) {
        SortingAndSearching3 T = new SortingAndSearching3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : T.insertionSort(arr, n)) System.out.print(i + " ");
    }
}
