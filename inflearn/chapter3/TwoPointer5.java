import java.util.Scanner;

// 최대 길이 연속 부분 수열
// 해결 못함. 다시풀어보기.
class TwoPointer5 {
    int solution(int n, int k, int[] arr) {
        // for 돌면서 0 나오면 k 만큼 메꾸고 k+1번째 0이 나올때 길이 측정.
        // 그것의 최댓값.
        // 포인터는 두번째 0 다음 1로 이동.
//        int p2 = 0;
//        int index = 0;
//        int length = 0;
//        int answer = 0;
//        int num = k;

        // 1 0 0 1 1 0 1 1 1 1
        // p1은 앞으로 계속 가고  세번째 0 나오면 다음 0이나 1로 이동해야함.
        // window를 밀고 가야한다. length는 두 인덱스간의 차.
        int p2 = 0;
        int length = 0;
        int answer = 0;
        int count = 0;
        for (int p1 = 0; p1 < n; p1++) {
            if (arr[p1] == 0) count++;
            // k보다 크면
            if (count > k) {
                while (arr[p2++] != 0) continue;
                count--;
            }
//            while (count > k) {
//                if (arr[p2++] == 0) count--;
//            }

            length = p1 - p2 + 1;
            if (length > answer) answer = length;

//            if (arr[p1] == 0 && num == 0) { //세번째(k+1 번째) num 마주치면
//                // 길이를 반환하고
//                length = p2 - p1;
//                if(answer < length) answer = length;
//
//                // k 번째 0의 인덱스를 찾아서 포인터 이동.
//                while (num2 != 0){
//                    if (arr[p2++] == 0) num2--;
//                }
//                num = k - 1;
//                num2 = k - 1;
//            }
        }
        return answer;

    }
    // 강사 풀이.
    int solution1(int n, int k, int[] arr) {
        int answer = 0, count = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) count++;
            while (count > k) {
                if (arr[lt++] == 0) count--;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
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
