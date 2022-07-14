public class ClassicString {
    // string.matches라는 것도 있다... (정규식과 비교)
    static boolean solution(String s) {
        // s 길이가 4또는 6이고 숫자로만 구성되어 있는지 확인
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return s.length() == 4 || s.length() == 6;
    }

    public static void main(String[] args) {
        System.out.println(solution("A1234"));
    }
}
