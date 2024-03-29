import java.util.Arrays;
import java.util.Scanner;

class SortingAndSearching1 {
    private int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    int[] selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
        return arr;
    }
    void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    // 선택정렬
    // i를 0번 부터, j = i+1 부터해서 j가 끝까지 도는 것.
    private int[] solution1(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SortingAndSearching1 T = new SortingAndSearching1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : T.selectionSort(arr, n)) System.out.print(i + " ");
    }
}
