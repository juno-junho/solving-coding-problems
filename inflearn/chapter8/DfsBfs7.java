import java.util.*;

// 조합의 경우수 (메모이제이션)
class DfsBfs7 {

    static int n;
    static int r;
    static int[] ch;
    static int answer = 0;
    static ArrayList<Set<Integer>> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    private void dfs(int l) {
        if (l == r) {
            if (list.contains(set)) return;
            list.add(new HashSet<>(set));
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    dfs(l + 1);
                    set.remove(i);
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