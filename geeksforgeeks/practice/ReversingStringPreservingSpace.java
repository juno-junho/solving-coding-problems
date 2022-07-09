public class ReversingStringPreservingSpace {
    // string을 뒤집는데, space는 유지한다.
    static void reverses(String str){
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ') result[i] = ' ';
        }
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            // 뒤에서 부터 result앞에서 부터 넣는데, chars가 공백이거나 result가 공백인 경우 건너뛰어야함.
            if (result[index] == ' ') index++;
            if (chars[chars.length-1-i] == ' ') {
                result[index] = chars[chars.length-2-i];
                index++;
                continue;
            }
            result[index] = chars[chars.length-1-i];
        }
        System.out.println(new String(result));
    }
    public static void main(String[] args) {
        reverses("internship at geeks for geeks");
    }
}