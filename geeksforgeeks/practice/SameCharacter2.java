import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SameCharacter2 {
    // 입력받은 string의 모든 문자가 일치하는지 안하는지 출력 방법 2. Set 시용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : s = ");
        String s = sc.nextLine();

        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        if (set.size() == 1) System.out.println("Output : Yes");
        else System.out.println("Output : No");
    }
}
