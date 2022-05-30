import java.util.Arrays;
import java.util.Scanner;

public class CharacterSorting {
    //Time Complexity: O(n log n), where n is the length of string.
    // function to print string in sorted order
    static void sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));
        System.out.println(String.valueOf(chars));
    }

    // 두번 째 방법 : loop 돌면서 각 알파벳 몇번 나왔는지 ++, 그리고 그 배열로 다시 출력
    static final int MAX_CHAR = 26;
    static void sortString2(String str) {
        int[] alphabet = new int[MAX_CHAR];
        for (char letter : str.toCharArray()) {
            alphabet[letter - 'a'] ++;
        }
        StringBuilder result = new StringBuilder();
        // 26번을 돌면서, 그 숫자에 alphabet[i]에 있는 수 만큼 character를 append.
        for (int i = 0; i < alphabet.length ; i++) {
            for (int j = 0; j < alphabet[i] ; j++) {
                result.append((char)('a' + i));
            }
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String s = sc.nextLine();
        sortString2(s);

    }
}
