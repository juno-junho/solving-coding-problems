import java.util.Scanner;

public class GroupWordChecker {

    static final int MAX_SIZE = 26;
    static boolean isGroupWord(String string){
        // 생각 1. 단어 돌면서 (1) 단어 개수랑 lastindexof로 비교
//        for (int i = 0; i < string.length(); i++) {
//            int i1 = string.indexOf(string.charAt(i));
//            int i2 = string.lastIndexOf(string.charAt(i));
//            if (countChar(string, string.charAt(i)) != (i2-i1+1)) return false;
//        }
//        return true;
        // 생각 2. 그냥 돌면서 지난 char랑 같으면 중복 ok but 다르면 false return
        // 다음게 같으면 그 다음것도 check. 같으면 check. but 다르면 return false.
//        for (int i = 0; i < string.length(); i++) {
//            for (int j = i+1; j < string.length(); j++) {
//               if(string.charAt(i) != string.charAt(i+1) && string.charAt(i) == string.charAt(j)) return false;
//            }
//        }
//        return true;
        // 생각 3. 인터넷 다른 사람 정답
        // check 배열을 만들고, check 배열을 이용해서 이전문자와 현재 문자 비교. 같으면 건너뛰고, 다르면 return false.
        boolean[] check = new boolean[MAX_SIZE];
        int prev = 0;
        for (int i = 0; i < string.length() ; i++) {
            int now = string.charAt(i);

            if (prev != now) {
                if (!check[now - 'a']){
                    check[now-'a'] = true;
                    prev = now;
                }
                else return false;
            }
        }
        return true;
    }

    static int countChar(String str, char ch){
        int count = 0;
        for (int i = 0; i <  str.length(); i++) {
            if (ch == str.charAt(i)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordNum = sc.nextInt();
        int result = 0;
        for (int i = 0; i < wordNum ; i++) {
            String word = sc.next();
//            System.out.println(word);
//            System.out.println(isGroupWord(word));
            if (isGroupWord(word)) result++;
        }
        System.out.println(result);
    }
}
