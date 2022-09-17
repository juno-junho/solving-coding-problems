import java.util.Arrays;
import java.util.Scanner;

// binary search 알고리즘 학습
class SortingAndSearching8 {
    int solution1(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        answer = Arrays.binarySearch(arr, m) + 1;
/*
        int lt = 0;
        int rt = n - 1;
        int mid;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) rt = mid - 1;
            if (arr[mid] < m) lt = mid + 1;
        }*/
        return answer;
    }
    int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == m) answer = i + 1;
        }
        return answer;
     }

    public static void main(String[] args) {
        SortingAndSearching8 T = new SortingAndSearching8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("n = " + n);
        int m = sc.nextInt();
        System.out.println("m = " + m);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution1(n,m,arr));
    }
}
