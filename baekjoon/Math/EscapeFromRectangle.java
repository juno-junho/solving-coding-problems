import java.util.Scanner;
import java.util.stream.IntStream;

public class EscapeFromRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        // 1. IntStream 사용
        int minValue = IntStream.of(x, w - x, y, h - y).min().getAsInt();
        System.out.println(minValue);

        // 2. Math.min() 사용
        int minX = Math.min(x,w-x);
        int minY = Math.min(y,h-y);
        System.out.println(Math.min(minX,minY));
    }
}
