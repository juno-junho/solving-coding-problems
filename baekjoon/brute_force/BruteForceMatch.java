import java.util.Scanner;

public class BruteForceMatch {
    public static int matching(String text, String pattern){
        int textIndex = 0;
        int patternIndex = 0;
        // 인덱스가 문자길이랑 같아지면 탈출.
        while (textIndex != text.length() && patternIndex != pattern.length()){
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)){
                textIndex++;
                patternIndex++;
            } else {
                textIndex = textIndex - patternIndex + 1;
                patternIndex = 0;
            }
        }
        // 검색 성공
        if (patternIndex == pattern.length()) return textIndex - patternIndex;
        // 검색 실패
        return -1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 텍스트용 문자열
        System.out.println("텍스트를 입력하세요 : ");
        String text = sc.next();
        // 검사할 패턴용 문자열
        System.out.println("패턴을 입력하세요 : ");
        String pattern = sc.next();
        // 텍스트용 문자열에서 패턴용 문자열을 검색
        int index = matching(text, pattern);
        if (index == -1) System.out.println("텍스트에 패턴이 없습니다.");
        else {
            // 패턴이 있을때, 길이와 인덱스 출력

            // length = index + pattern 길이
            int length = 0;
            for (int i = 0; i < index ; i++) {
                length += text.substring(i, i + 1).getBytes().length;
            }
            length += pattern.length();

            System.out.println((index + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + text);
            System.out.printf(String.format("패턴 : %%%ds\n", length), pattern);
            System.out.println(length);
//            System.out.printf("패턴 : %5s\n", pattern);
        }
    }
}
