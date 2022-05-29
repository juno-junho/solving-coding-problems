import java.util.Scanner;

public class SameCharacter {
    // 입력받은 string의 모든 문자가 일치하는지 안하는지 출력 방법 1.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : s = ");
        String s = sc.nextLine();

        boolean flag = true;
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(0) != s.charAt(i)) {
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("Output : Yes");
        else System.out.println("Output : No");
    }
}
