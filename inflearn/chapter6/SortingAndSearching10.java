import java.util.Arrays;
import java.util.Scanner;

// 결정 알고리즘 사용 문제 2-> 최솟값과 최댓값 사이에 답이 무조건 있을때 사용한다.
class SortingAndSearching10 {

    //강사 풀이.
    int count(int[] arr, int dist) {
        int count = 1;
        int ep = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                count++;
                ep = arr[i];
            }
        }
        return count;
    }
    int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1] - arr[0];

        while (lt <= rt) {
            // 말 사이 거리 최솟값
            int mid = (lt + rt) / 2;
            int count = 1;
            // logic start
            for (int i = 0; i < n-1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((arr[j] - arr[i]) >= mid) {
                        i = j - 1;
                        count++;
                        break;
                    }
                }
            }
            // logic end
            if (count >= c) {
                answer = mid;   // possible
                lt = mid + 1;
            } else rt = mid - 1;    // impossible
        }
        return answer;
    }
    public static void main(String[] args) {
        SortingAndSearching10 T = new SortingAndSearching10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, c, arr));
    }
}
