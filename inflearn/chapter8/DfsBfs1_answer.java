import java.util.Scanner;

// 합이 같은 부분 집합
class DfsBfs1_answer {
    // 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우 존재시 YES. 없으면 NO 출력
    static String answer = "NO";
    static int total = 0;
    static int n = 0;
    static boolean flag = false;
    private void dfs(int l, int sum, int[] arr){
        if (flag) return;
        if (sum > total/2) return;
        if (l == n){ // 6호출
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        }else{
            dfs(l + 1, sum + arr[l], arr);
            dfs(l + 1, sum, arr); // 정확히 왜 빼줘야하는지는 모르겠음.
        }
    }


    public static void main(String[] args) {
        DfsBfs1_answer T = new DfsBfs1_answer();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.dfs(0, 0, arr);
        System.out.println(answer);
    }

}
