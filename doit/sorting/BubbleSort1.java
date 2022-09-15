import java.util.Arrays;

class BubbleSort1 {
    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    // bubble sort
    // 끝에서 부터 정렬
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }
    // 처음 부터 정렬. 큰 값을 뒤로 보낸다.
    static void bubbleSort1(int[] a, int n) {
        // a[0], a[1], a[2], .. a[n-1] 까지 요소 비교후 수행.
        for (int i = 0; i < n - 1; i++) {
            // 어디까지 돌아야 할지 범위 제한.
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
    }

    // 알고리즘 개선. 바꾸는데 바꾼 횟수가 0이면 더 이상 정렬할 요소가 없다 -> 정렬 멈추기.
    static void bubbleSort2(int[] a, int n) {
        // a[0], a[1], a[2], .. a[n-1] 까지 요소 비교후 수행.
        for (int i = 0; i < n - 1; i++) {
            // 어디까지 돌아야 할지 범위 제한.
            int swapNum = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapNum++;
                }
            }
            if (swapNum == 0) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 8, 9};
        bubbleSort2(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
