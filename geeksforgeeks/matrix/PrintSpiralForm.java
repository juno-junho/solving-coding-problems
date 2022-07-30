import java.util.ArrayList;
import java.util.List;

public class PrintSpiralForm {
    // algorithms : R row 와 C column일때, seen[r]은 r번째 row와 c번째 column의 cell이 방문한적이 있다는 것을 말한다.
    // 현재 current position은 (r,c)이고, 모든 cell을 방문하려고 한다.
    // matrix에서 움질일때, 다음 포지션은 (cr,cc)이다. 만약 candidate가 matrix와 unseen의 영역에 있어면 다음 positon이 되고
    // 안그러면 다음 포지션은 clockwise turn을 수행한다.
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // matrix가 비어있을때
        if (matrix.length == 0) return ans;

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[][] seen = new boolean[rowLength][colLength];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x = 0, y = 0, di= 0;

        for (int i = 0; i <rowLength*colLength ; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (cr >= 0 && cr < rowLength && cc >= 0 && cc < colLength && !seen[cr][cc]){
                x = cr;
                y = cc;
            }else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }

}
