import java.util.Arrays;
import java.util.Scanner;

// 순열 구하기
class DfsBfs6 {
    /**
     // 내풀이의 잘못된점 : 순서 유지가 안된다. ch배열에서 끄집어 낼때 순서 유지가 안됨.
     // 따라서 pm 배열이 필요한 것이였음.!!!
     */

    static int n;
    static int m;
    static int[] arr;
    static int[] ch;
    private void dfs(int l, String str) {
        if (l == m) {
            System.out.println(str);
        } else {
            l++;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) continue;
                ch[i] = 1;
                dfs(l, str + arr[i] + " ");
                ch[i] = 0;
            }
        }
    }

    private void dfs(int l) {
        if (l == m) {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        DfsBfs6 T = new DfsBfs6();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println(Arrays.toString(arr));

//        T.dfs(0, new String());
        T.dfs(0);

    }
}