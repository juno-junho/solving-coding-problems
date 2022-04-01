import java.util.Scanner;

public class Hive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1 7 19 37 61
        // 6 12 18 24 ...
        int x = 1;
        int num = 1;
        while (true){
            if (x ==n) {
                System.out.println(num);
                break;
            }
            if (x < n && n < x + 6*num){
                System.out.println(num+1);
                break;
            }
            x += 6*num;
            num++;
        }

    }
}
