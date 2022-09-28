import java.util.*;

// 조합의 경우수 (메모이제이션)
class DfsBfs7 {

    static int n;
    static int r;
    static int[] ch;
    static int answer = 0;
    static ArrayList<Set<Integer>> list = new ArrayList<>();
    private void dfs(int l) {
        if (l == r) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n + 1; i++) {
                if (ch[i] == 1) set.add(i);
            }
            for (Set<Integer> integerSet : list) {
                if (integerSet.equals(set)) return;
            }
            list.add(set);
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;

                    dfs(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs7 T = new DfsBfs7();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        ch = new int[n + 1];

        T.dfs(0);
        System.out.println(answer);

    }
}