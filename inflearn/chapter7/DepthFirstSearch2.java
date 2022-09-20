import java.util.Scanner;

// 부분집합 구하기
// 자연수 N이 주어지면, 1 ~ N까지의 원소를 갖는 집합의 부분집합을 모두 구하는 프로그램 작성. 단 공집합은 출력 x
class DepthFirstSearch2 {
    // 집합 원소의 개수
    static int n;
    // check 배열 -> 부분집합으로 사용한다 / 사용하지 않는다 확인하기 위해서.
    static int[] ch;
    // 이진 트리를 만들면 됨.
    private void dfs(int l) {
        if (l == n + 1) {   // 종착점에 왔을때
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp += (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp); // 공집합이 아니면 출력한다
        }else{
            ch[l] = 1;
            dfs(l + 1); // 왼쪽으로 뻗기
            ch[l] = 0;
            dfs(l + 1); // 오른쪽으로 뻗기
        }
            
    }

    public static void main(String[] args) {
        DepthFirstSearch2 T = new DepthFirstSearch2();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n + 1];
        T.dfs(1);
    }
}
