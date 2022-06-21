public class StringNumber {
    // 시간이 정말 오래 걸림. 완전 삽질.
    // string method 다시 공부하기.. replace all.. regex만 되는게 아니네..

    static int solution(String s) {
        // 문자열 탐색
        // one two three four five six seven eight nine ten
        // 어떻게 바꿔야 하냐... ㅇ
//        s.replaceAll("zero", "0")

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length()-3 ; i++) {
            if(sb.substring(i,i+4).equals("zero")){
                sb.replace(i,i+4,"0");
            }
        }

        for (int i = 0; i < sb.length()-2 ; i++) {
            if (sb.substring(i, i + 3).equals("one")) {
                sb.replace(i, i + 3, "1");
            }
        }

        for (int i2 = 0; i2 < sb.length()-2 ; i2++) {
            if(sb.substring(i2,i2+3).equals("two")){
                sb.replace(i2,i2+3,"2");
            }
        }

        for (int i3 = 0; i3 < sb.length()-4 ; i3++) {
            if(sb.substring(i3,i3+5).equals("three")){
                sb.replace(i3,i3+5,"3");
            }
        }

        for (int i4 = 0; i4 < sb.length()-3 ; i4++) {
            if(sb.substring(i4,i4+4).equals("four")){
                sb.replace(i4,i4+4,"4");
            }
        }

        for (int i5 = 0; i5 < sb.length() -3; i5++) {
            if(sb.substring(i5,i5+4).equals("five")) {
                sb.replace(i5,i5+4,"5");
            }
        }

        for (int i6 = 0; i6 < sb.length() -2; i6++) {
            if(sb.substring(i6,i6+3).equals("six")){
                sb.replace(i6,i6+3,"6");
            }
        }
        System.out.println("6" + sb);
        for (int i7 = 0; i7 < sb.length()-4 ; i7++) {
            if(sb.substring(i7,i7+5).equals("seven")) {
                sb.replace(i7,i7+5,"7");

            }
        }
        System.out.println(sb);

        for (int i8 = 0; i8 < sb.length() -4; i8++) {
            if(sb.substring(i8, i8+5).equals("eight")) {
                sb.replace(i8, i8+5,"8");
            }
        }

        for (int i9 = 0; i9 < sb.length()-3 ; i9++) {
            if (sb.substring(i9, i9 + 4).equals("nine")) {
                sb.replace(i9, i9 + 4, "9");
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution("sevenseven"));
    }
}
