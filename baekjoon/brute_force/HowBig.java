import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HowBig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> peopleList = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] big = {x,y};
            peopleList.add(big);
        }
        int xMax = 0;
        int yMax = 0;
        for (int[] arr:peopleList) {
            for (int x:arr) {
            }
        }

    }
}
