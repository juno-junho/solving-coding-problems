import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 조합 구하기
class DfsBfs9 {

    static int n;
    static int m;
    static int[] ch;

    static ArrayList<Set<Integer>> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    private void dfs(int l) {
        if (l == m) {
            if (list.contains(set)) return;
            list.add(new HashSet<>(set));
            for (Integer x : set) System.out.print(x + " ");
            System.out.println();
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
        DfsBfs9 T = new DfsBfs9();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        T.dfs(0);

    }
}