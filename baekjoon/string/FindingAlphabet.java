import java.util.Scanner;

public class FindingAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // a b c d e f g h .. 알파벳이 string s 를 돌면서 일치하는게 있으면 index, 없으면 -1 출력.
        // 1. 내가 한 방법
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        String[] alphabetStrings = alphabet.split("");
//        for (String a : alphabetStrings) {
//            System.out.print(s.indexOf(a) + " ");
//        }
        // 2. 다른사람 방법. ASCII 사용한 char도 for문 돌릴수 있구나..
        for (char i = 'a'; i<='z'; i++){
            System.out.print(s.indexOf(i) +  " ");
        }

    }
}
