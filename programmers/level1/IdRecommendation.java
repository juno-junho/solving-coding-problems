public class IdRecommendation {
    // 후기 : 남의 코드 보기 + 정규표현식 공부하기.
    public String solution(String new_id) {
        // 아이디는 3자이상 15자 이하
        // 소문자, 숫자 , - , _, .만 사용가능
        // 마침표는 처음과 끝에 사용할수 없고, 연속으로 사용 불가.
        // 단계 1. 대문자 -> 소문자
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());

        // 단계 2. 알파벳, 숫자, 빼기, 밑줄, 마침표 제외한 모든 문자 제거.
        for (int i = 0; i < sb.length() ; i++) {
            if (sb.charAt(i) != '.' && sb.charAt(i) != '-' && sb.charAt(i) != '_' &&
                    !(sb.charAt(i) >= 48 && sb.charAt(i) <= 57) &&
                    !(sb.charAt(i) >= 97 && sb.charAt(i) <= 122)) {
                sb.delete(i,i+1);
                i--;
            }
        }
        // 단계 3. .. 두번 이상 연속 되면 하나의 마침표로 치환
        for (int i = 1; i < sb.length() ; i++) {
            if (sb.charAt(i) == '.' && sb.charAt(i-1) =='.'){
                sb.delete(i,i+1);
                i--;
            }
        }
        // 단계 4. 마침표가 처음이나 끝 위치 하면 제거.
        deletedot(sb);
        // 단계 5. 빈문자열이라면 "a"대입
        if (sb.length() == 0) sb.append("a");
        // 단계 6. 15문자까지 짜르기
        if (sb.length() > 15) deletedot(sb.delete(15, sb.length()));
        //단계 7. 길이가 2이하이면 머지막문자를 3이 될때까지 반복해서 붙힘.
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length()-1));
        }

        return sb.toString();
    }
    static StringBuilder deletedot(StringBuilder str) {
        if (str.length() == 0) return str;
        if (str.charAt(str.length()-1) == '.') str.delete(str.length()-1, str.length());
        if (str.length() == 0) return str;
        if (str.charAt(0) == '.') str.delete(0,1);
        return str;
    }
    public static void main(String[] args) {
        IdRecommendation test = new IdRecommendation();
        String new_id = "123_.def";
        System.out.println(test.solution(new_id));

    }
}
