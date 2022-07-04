import java.util.Scanner;

public class ChapterOneWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        System.out.print("b의 값 : ");
        int b = sc.nextInt();

        while (a >= b) {
            System.out.println("a 보다 큰 값을 입력하세요");
            System.out.print("b의 값 : ");
            b = sc.nextInt();
        }
        System.out.println("b - a는 " + (b-a) + "입니다.");

//        do{
//            // 반복할 문장들 -> 한번은 수행됨
//        }while ();
//            // 조건 만족하면 do 구문 실행함.
    }
}
