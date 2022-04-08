import java.util.Arrays;
import java.util.Scanner;

public class ACMHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Test
        int testNum = sc.nextInt();

        // 생각 프로세스 : 1. 101~H01까지 채우기
        // 2. 102~h02 채우기.
        // N % H 가 층수, N / H+ 1 이 호수
        for (int i = 0; i < testNum; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int floor =N %H;
            int num;
            if (floor ==0){
                floor = H;
                num = N/H;
            }else num = (N/ H) + 1;
            System.out.println(floor *100 + num);
        }
    }
}