import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TwoPointer2 {
    // 두 집합이 주어 졌을때, (중복 x) 공통원소를 오름차순으로 정렬해 출력.
    // 1. 두 집합을 정렬 한다.
    // 2. 포인터를 두개로 잡고 값이 같으면 arrayList에 추가. 그리고 두 포인터 둘다 증가.
    // 3. 다르면 작은쪽 포인터 증가.
    // 4. 아무 쪽 끝나면 그냥 끝.

    
    List<Integer> solution(int n, int m, int[] a, int[] b){
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m){
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }
            else if (a[p1] < b[p2]) p1++;
            // (a[p1] > b[p2])
            else p2++;
        }
        return answer;
    }
    public static void main(String[] args) {
        TwoPointer2 T = new TwoPointer2();
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
