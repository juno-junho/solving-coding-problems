public class ReversingIndividualWords {
    // 방법은 정말 많다..
    static String reverseIndividual(String str){
        // 방법 1. stack 사용 *** 공부해보기 (지금하기 싫음)
        // 방법 2. stream사용
        // 방법 3. 내방법
        StringBuilder sb = new StringBuilder();
        String[] words = str.split(" ");
        for (String word : words) {
            sb.append(reverseString(word)).append(" ");;
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
    static String reverseWordsInString(String str){
        // 방법 1. charArray로 바꾼 다음 for 돌면서 ' '만나면 글자 reverse하기(변수 start, end 설정). 그리고 맨 끝 글자 reverse하기
        // 방법 2. 내가 한 방법
        // 방법 3. split으로 쪼개서 단어 한글자씩 돌린다음 String.join()사용해서 붙히기.
        //  reverse하는 방법이 for로 글자 짝수인지 홀수인지 구분해서 한글자씩 바꿔줌
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i>=0; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String s = "getting good at coding needs a lot of practice";
        System.out.println(reverseWordsInString(s));
    }
}
