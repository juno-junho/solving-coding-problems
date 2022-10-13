package engineerkorea;

class CompressionString {
    public static void main(String[] args) {
        System.out.println(compressString("aabbcccddddd"));
        System.out.println(compressString("absdf"));
    }
    // compress 한것과 일반 문자열과 비교해서 compress 한것의 길이가 더 길다면 일반 문자열 반환.
    private static String compressString(String str) {
        String newStr = compress(str);
        return str.length() < newStr.length() ? str : newStr;
    }
    // StringBuilder쓰기
    private static String compress(String str) {
        int count = 0;
        StringBuilder newString = new StringBuilder(getTotal(str));
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                newString.append(str.charAt(i));
                newString.append(count);
                count = 0;
            }
        }
        return newString.toString();
    }
    // StringBuilder의 값 초기화. (저장공간 부족으로 복사하는 것 방지하기 위해서)
    private static int getTotal(String str) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                total = 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return total;
    }

}
