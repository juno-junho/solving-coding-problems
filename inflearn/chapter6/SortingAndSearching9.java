import java.util.Arrays;
import java.util.Scanner;

class SortingAndSearching9 {
    //뻘짓함. 내가 한 풀이는 정렬 한 다음 하는 건데 문제는 정렬 하란말이 없음.
//    int solution(int n, int m, int[] arr) {
//        // idea : 최솟값 (9 : 한장만 담을경우) 최댓값 앨범 모두를 담을 경우 를 이분탐색 돌면서 알맞는지 확인.
//        Arrays.sort(arr);
//        int answer = 0;
//        int lt = arr[n - 1];
//        int rt = 0;
//        for (int i : arr) rt += i;
//        // arr 돌면서 순차적으로 돌면서 mid 값보다 커지기 전까지 담음.
//        while (lt <= rt) {
//            int mid = (lt + rt) / 2;
////            if (lt == rt) return mid + 1;
//            int sum = 0;
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                sum += arr[i];
//                if (sum > mid) {
//                    count++;
//                    sum = arr[i];
//                }
//            }
//            // 담을수 있으면
//            if (count <= m - 1) rt = mid - 1;
//            // 담을 수 없으면
//            else if (count > m - 1) lt = mid + 1;
//        }
//        return rt + 1;
//
//    }

    int solution1(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > mid) {
                    count++;
                    sum = arr[i];
                }
            }
            // 담을 수 있다
            if (count <= m) {
                answer = mid;
                rt = mid - 1;
            }
            // 담을 수 없다
            else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        SortingAndSearching9 T = new SortingAndSearching9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution1(n, m, arr));
    }
}
