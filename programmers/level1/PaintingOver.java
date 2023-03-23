import java.util.*;

public class PaintingOver {

    public int solution(int n, int m, int[] section) {
        // 그냥 순서대로 하면 된다.
        int count = 0;
        int validNum = 0;
        for (int region : section) {
            if (region <= validNum) {
                continue;
            }
            validNum = region + m - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        PaintingOver paintingOver = new PaintingOver();
        int result = paintingOver.solution(4, 1, new int[]{1, 2, 3, 4});
        System.out.println(result);

    }
}
