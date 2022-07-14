public class StringToInt {
    static int solution(String s) {
        if (s.startsWith("+")) return Integer.parseInt(s.substring(1));
        if (s.startsWith("-")) return Integer.parseInt(s.substring(1))*(-1);
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {


    }

}
