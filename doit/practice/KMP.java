public class KMP {
    static int kmpMatch(String text, String pattern) {
        int textIndex = 1;  // text 커서
        int patternIndex = 0;  // pattern 커서
        int[] skip = new int[pattern.length() + 1]; // 건너뛰기 표

        // 건너뛰기 표 생성
        skip[textIndex] = 0;
        while (textIndex != pattern.length()) {
            if (pattern.charAt(textIndex) == pattern.charAt(patternIndex)) skip[++textIndex] = ++patternIndex;
            else if (patternIndex == 0) skip[++textIndex] = patternIndex;
            else patternIndex = skip[patternIndex];
        }
        // 검색
        patternIndex = textIndex = 0;
        while (textIndex != text.length() && patternIndex != pattern.length()){
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)){
                textIndex++;
                patternIndex++;
            }else if (patternIndex == 0) textIndex++;
            else patternIndex = skip[patternIndex];
        }
        if (patternIndex == pattern.length()) return textIndex - patternIndex; // return
        return  -1; // 검색 실패
    }
}
