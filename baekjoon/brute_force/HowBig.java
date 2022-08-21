
import java.util.Scanner;

public class HowBig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] height = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n ; i++) {
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }
        int count = 1;
        for (int i = 0; i < n ; i++) {
            // 하나하나 돌면서 자기 보다 weight과 height가 모두 큰 사람 count
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if((weight[i] < weight[j]) && (height[i] < height[j])) count++;
            }
            rank[i] = count;
            count = 1;
        }
        for (int i : rank) {
            System.out.print(i + " ");
        }


    }
}
