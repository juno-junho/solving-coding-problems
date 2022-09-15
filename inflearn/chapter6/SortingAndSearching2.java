import java.util.Scanner;

class SortingAndSearching2 {
     int[] bubbleSort1(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
         return a;
    }
    void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        SortingAndSearching2 T = new SortingAndSearching2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : T.bubbleSort1(arr, n)) System.out.print(i + " ");
    }
}
