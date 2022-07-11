public class MiddleString{
    static String solution(String s) {
        if (s.length() % 2 == 1){
            int middleIndex = (s.length() / 2);
            return s.charAt(middleIndex) + "";
        }else {
            return "" + s.charAt(s.length()/2-1) + s.charAt(s.length()/2);
        }
    }
    static String solution2(String s) {
        return s.substring((s.length()-1)/2, s.length()/2 +1);
    }

    public static void main(String[] args) {
        System.out.println(solution("qwer"));
    }
}
