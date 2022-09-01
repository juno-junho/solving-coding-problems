import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TwoPointer1 {
    // 오름차순으로 정렬되어 있는 두 배열을 오름차순으로 합치는 프로그램.
    // 그냥 배열 두개 합쳐서 sort 하면 O(nlogn) 하지만 이 two pointers algorithm 사용하면 O(n).

    List<Integer> solution(int n, int m, int[] a, int[] b){
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2  = 0;
        while (p1 < n && p2 < m){
            if (a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);

        return answer;
    }
    public static void main(String[] args) {
        TwoPointer1 T = new TwoPointer1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for (int x : T.solution(n,m,a,b)) System.out.print(x + " ");
        
    }
}
