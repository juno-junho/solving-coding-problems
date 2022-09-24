import java.util.Scanner;

// 합이 같은 부분 집합
class DfsBfs1 {
    // 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우 존재시 YES. 없으면 NO 출력
    // 내코드의 문제 : sum += arr[num]을 사용하면 넘기는 sum값 또한 다 바뀌게 된다. -> 출력값이 모두 32(total값)로 나오는 이유.
    private String solution(int n, int[] arr) {
        String answer = "NO";

        return answer;
    }

    static int total;
    static int n;
    static int[] arr;
    static boolean flag;
    private void dfs(int num, int sum){
        if (num == n){ // 6호출
            System.out.println("total = " + total);
            System.out.println("sum = " + sum);
            if (total - sum == sum) flag = true;
        }else{
            dfs(num + 1, sum += arr[num]);
            dfs(num + 1, sum); // 정확히 왜 빼줘야하는지는 모르겠음. (위에 sum+=를 해줬기 때문에. 안하는게 맞음)
        }
    }


    public static void main(String[] args) {
        DfsBfs1 T = new DfsBfs1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
//        ch = new int[n + 1];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
//        System.out.println(T.solution(n, arr));
        for (int i : arr) total += i;
        T.dfs(0, 0);
        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

}
