import java.util.Scanner;

// 최대 길이 연속 부분 수열
class TwoPointer5 {
    int solution(int n, int k, int[] arr) {
        // for 돌면서 0 나오면 k 만큼 메꾸고 k+1번째 0이 나올때 길이 측정.
        // 그것의 최댓값.
        // 포인터는 두번째 0 다음 1로 이동.

        // p1은 앞으로 계속 가고  세번째 0 나오면 p2는 두번째 0 다음으로 이동.


        int p2 = 0;
        int index = 0;
        int length = 0;
        int max = 0;
        int num = k;
        for (int p1 = 0; p1 < n; p1++) {
            if (num == 0 && arr[p1] == 0){
                if (length > max) max = length;

            }
            length++
            if (arr[p1] == 0) num--;
            if (num == 0 && arr[p1] == 0) index = p1;
        }
        return max;

    }


    public static void main(String[] args) {
        TwoPointer5 T = new TwoPointer5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, a));
    }

}
