import java.util.*;

// 등수구하기
class Array8 {
    // 정렬 이용
    int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        int[] beforeSorted = Arrays.copyOf(arr, n);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (beforeSorted[i] == arr[j]) answer[i] = n-j;
            }
        }
        return answer;
    }
    // 강사풀이 == 내풀이
    int[] solution1(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] > arr[i]) count++;
            }
            answer[i] = count+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Array8 T = new Array8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        for (int i : T.solution1(n, arr)) System.out.print(i + " ");
    }
}
