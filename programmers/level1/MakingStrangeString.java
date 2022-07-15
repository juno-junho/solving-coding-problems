
public class MakingStrangeString {
    // 다시 풀어보기. 너무 길개품

    static String solution2(String s) {
        String answer = "";
        int cnt = 0; // 공백 개수
        String[] arr = s.split("");
        for (String str : arr) {
            cnt = str.contains(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? str.toLowerCase() : str.toUpperCase();
        }
        return answer;
    }
    static String solution(String s) {
        // 공백 index 저장해 놨다가 단어만 바꿔서 공백 삽입하기
        // 그냥 stringbuilder로 append 하기..
        String[] words = s.split("\\s");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length-1){
                result.append(toStrange(words[i]));
                break;
            }
            result.append(toStrange(words[i])).append(" ");
        }
        int  length= result.length();
        for (int i = 0; i < s.length() -length ; i++) {
            result.append(" ");
        }
        return result.toString();
//        char[] chars = s.toCharArray();
//        boolean flag = false;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] != ' ') flag = true;
//            if (fl)
//        }
    }
    static String toStrange(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i % 2 == 0) chars[i] = Character.toUpperCase(chars[i]);
            else chars[i] = Character.toLowerCase(chars[i]);
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        System.out.println("After :" + solution("abs  sdfa  sdafd     " ));
        String str = "abs  sdfa  sdafd     ";
        String[] split = str.split("");
        for (String s : split) {
            System.out.print(s);
        }
    }

}
