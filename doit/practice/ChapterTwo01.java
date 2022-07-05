import java.util.Random;
import java.util.Scanner;
// random에 대하여  : https://evan-moon.github.io/2019/07/14/what-is-random/
public class ChapterTwo01 {
    static int maxOf(int[] a){
        int max = a[0];
        for (int i : a) {
            if (i > max) max = i;
        }
        return max;
    }
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        int num = r.nextInt(10) + 1;
        System.out.println("사람의 수 : " + num);
        int[] height = new int[num];
        System.out.println("키 값은 아래와 같습니다");
        for (int i = 0; i < num ; i++) {
            height[i] = 100 + r.nextInt(90); // 0~89 까지의 난수
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");

    }
}
