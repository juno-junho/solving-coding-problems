
public class NextBiggerNum {
    //다음 큰 숫자 문제 다름 사람 풀이 확인
    // 이거 이해하기
    public int nextBigNumber(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
    public int solution(int n) {

        String s = Integer.toBinaryString(n);
        // n의 1개수
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '1') num++;
        }
//        int length = s.replaceAll("0", "").length();
        String binaryString = "";
        int num1 = 0;
        while (true){
            n++;
            binaryString = Integer.toBinaryString(n);
            char[] chars1 = binaryString.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] == '1') num1++;
            }
            if (num == num1) break;
            num1 = 0;
        }
        return n;

    }

    public static void main(String[] args) {
        int n = 78;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int length = s.replaceAll("0", "").length();
        System.out.println(s);
        System.out.println(length);

    }
}
