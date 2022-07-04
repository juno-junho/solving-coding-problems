import java.util.Scanner;

public class ChapterOneWhile2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            a = sc.nextInt();
        }while (a <= 0);
        int digit = 1;
        while (a / 10 != 0){
            digit ++;
            a /= 10;
        }
        System.out.println("number digit is : " + digit);
    }
}
