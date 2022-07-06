import java.util.Scanner;

public class ChapterTwoCardinal {
    static int cardConvR(int x, int r, char[] d){
        // 정수값 x를 r진수로 변환하여 배열 d에 아랫자리 부터 넣어두고 자릿수 반환. (digit 반환)
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            // x % r: 정수(10진수)를 r로 나눈 나머지
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        }while (x != 0);
        return digits;

    }
    static int cardConv(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        do {
            d[digits] = dchar.charAt(x % r);
            x /= r;
        }while (x != 0);
        for (int i = 0; i < d.length / 2 ; i++) {
            char temp = d[i];
            d[i] = d[d.length-1-i];
            d[d.length-1-i] = temp;
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no;         // 변환하는 정수
        int cd;         // 기수 (몇 진수)
        int dno;        // 변환 후의 자릿수 (digit)
        int retry;      // 다시 한번?
        char[] cno = new char[32];  // 변환 후 각 자리의 숫자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.println("음이 아닌 정수 : ");
                no = sc.nextInt();
            } while (no < 0);
            do {
                System.out.println("어떤 진수로 변환할까요? (2 ~ 36) : ");
                cd = sc.nextInt();
            } while (cd < 2 || cd > 36);
            dno = cardConvR(no, cd, cno);
            System.out.println(cd + "진수로는 ");
            //역으로 꺼냄.
            for (int i = dno - 1; i >= 0 ; i--) System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1.예/0.아니오) :");
            retry = sc.nextInt();
        } while (retry == 1);
    }


}
