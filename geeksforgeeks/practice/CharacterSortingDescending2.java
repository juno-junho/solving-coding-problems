import java.util.Scanner;

public class CharacterSortingDescending2 {

    // 알파벳은 26개의 캐릭터 밖에 없다. 따라서 크기가 26인 hashed array를 만들어서 index를 해당 문자로 변환
    static final int MAX_CHAR = 26;

    static void descOrder(String str) {
        int[] charCount = new int[MAX_CHAR];
        for (int i = 0; i < str.length() ; i++) {
            charCount[str.charAt(i) -'a']++;
        }
//        O(MAX_CHAR * n)
        for (int i = MAX_CHAR - 1; i >= 0; i--) {
            for (int j = 0; j < charCount[i] ; j++) {
                System.out.print((char)(i + 'a'));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        descOrder(s);
    }
}
