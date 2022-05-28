public class StringToNewCharacter {
    // 1. hashing of new character set where element of set is index and its position will be new alphabet value.

    static String conversion(char charSet[], String str) {
        int n = str.length();

        // hashing for new character set
        // 새로운 hash를 만드는 것.
        //
        char hashChar[] = new char[26];
        // 17번째(ch) hashChar에 a 부터 알파벳 순서로 집어 넣음.
        for (int i = 0; i < 26; i++) {
            int ch = Math.abs(charSet[i] - 'a');
            hashChar[ch] = (char) ('a' + i);
        }
        // After hashing our new character set is “kxvmcnophqrszyijadlegwbuft”.

        // conversion of new character set
        StringBuilder s= new StringBuilder();
        // 변환하고자 하는 string의 한 글자 마다 순서를
        for (int i = 0; i < n; i++) {
            s.append(hashChar[str.charAt(i) - 'a']);
        }
        return s.toString();
    }

    // Driver code
    public static void main(String[] args) {
        char charSet[] = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        String str = "egrt";
        str = conversion(charSet, str);
        System.out.println(str);
// This code is contributed by princiRaj1992
    }
}
