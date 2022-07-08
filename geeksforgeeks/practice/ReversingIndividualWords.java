public class ReversingIndividualWords {
    static String reverseWord(String str){
        StringBuilder sb = new StringBuilder();
        String[] words = str.split(" ");
        for (String word : words) {
            sb.append(reverseString(word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    static String reverseString(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = temp;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(reverseWord(s));
    }
}
