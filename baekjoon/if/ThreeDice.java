
import java.util.Scanner;
import java.util.stream.IntStream;

public class ThreeDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int r3 = sc.nextInt();

        int max = IntStream.of(r1, r2, r3).max().getAsInt();
        // 3개 모두 같은거 거르고 -> 두개 같은것 거르고 -> 나머지
//        if(r1 == r2 && r2 ==r3){
//            System.out.println(10000 + (r1*1000));
//        }else if (r1 == r2 || r2 == r3 || r1 == r3){
//            System.out.println(1000 + 100*);
//        }
//
        boolean b1 = r1==r2;
        boolean b2 = r2==r3;
        boolean b3 = r1==r3;
        boolean b4 = b1 && b3;
        int price = 0;

        if (!b1 && !b2 && !b3) price = max * 100;
        if (b4) price = 10000 + (r1*1000);
        else if (b1) price = r1*100 +1000;
        else if (b2) price = r2*100 +1000;
        else if (b3) price = r3*100 +1000;
        System.out.println(price);
    }

}
