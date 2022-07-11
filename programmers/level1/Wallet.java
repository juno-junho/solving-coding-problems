import java.util.Arrays;
import java.util.stream.Stream;
// stream 사용법.
public class Wallet {
    static int solution(int[][] sizes) {
        // 일단 sizes [i][j]의 이차원 배열에서 i가 더 크도록 정렬 한다음
        // i 중에 제일 큰것, j 중에 제일 큰것 구한다.
        // 1. 직접 바꾼다.
        for (int[] size : sizes) {
            for (int i = 0; i < size.length; i++) {
                if (size[0] < size[1]) {
                    int temp = size[0];
                    size[0] = size[1];
                    size[1] = temp;
                }
            }
        }
        // 2. max와 min 구한다
        int widthMax = sizes[0][0];
        int heightMax = sizes[0][1];
        for (int[] size : sizes) {
            if (widthMax < size[0]) widthMax = size[0];
            if (heightMax < size[1]) heightMax = size[1];
        }
        return widthMax * heightMax;
    }
    static int solution2(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int[] size : sizes) {
            width = Math.max(width,Math.max(size[0],size[1]));
            height = Math.max(height,Math.min(size[0], size[1]));
        }
        return width * height;
    }
    static int solution3(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).get();
    }

    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };
        System.out.println(solution(sizes));
    }
}
