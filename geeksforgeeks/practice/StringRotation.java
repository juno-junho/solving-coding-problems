public class StringRotation {

    // 방법 1. 0부터 n-1까지 loop
    // rotation할 때 마다, 임시의 string의 두번째 글자를 복사하고, 기존 string의 첫 글자를 temporary String에 복사한다
    static void printRotatedString(String str){
        StringBuffer sb ;

        for (int i = 0; i < str.length(); i++) {
            sb = new StringBuffer();
            int strIndex = i;
            int tempIndex = 0;

            for (int j = strIndex; j < str.length() ; j++) {
                sb.insert(tempIndex, str.charAt(strIndex));
                tempIndex++;
                strIndex++;
            }
            strIndex = 0;
            while (strIndex < i){
                sb.insert(tempIndex, str.charAt(strIndex));
                strIndex++;
                tempIndex++;
            }
            System.out.println(sb.toString());
        }

    }
    public static void main(String[] args) {
        String  str = new String("geeks");
        printRotatedString(str);
    }
}

