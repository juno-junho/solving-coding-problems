import java.util.Scanner;
import java.util.stream.IntStream;

public class rightAngledTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            int side1 = sc.nextInt();
            int side2 = sc.nextInt();
            int side3 = sc.nextInt();
            if (side1==0 && side2==0 && side3==0) break;

            int adjacent =0, opposite=0, hypotenuse=0;
            hypotenuse = IntStream.of(side1, side2, side3).max().getAsInt();

            if (hypotenuse == side1) {
                adjacent = side2;
                opposite = side3;
            }
            if (hypotenuse == side2) {
                adjacent = side1;
                opposite = side3;
            }  if (hypotenuse == side3) {
                adjacent = side2;
                opposite = side1;
            }

            if (hypotenuse*hypotenuse == (adjacent*adjacent + opposite*opposite)){
                System.out.println("right");
            }else System.out.println("wrong");
        }
    }
}
