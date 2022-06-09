public class StringRotation {
    static void printRotatedString(String str) {
        //내 방법 : string.length만큼 for문을 돌면서, 첫문자를 마지막 문자로 넣는다. 그리고 나머지는 자리 한칸 땡겨준다
        StringBuilder sb;
        StringBuilder temp = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            sb = new StringBuilder();
            // string의 첫문자를 뒤에다 붙혀준다. 그리고 그것을 temp로 update시킴.
            sb.append(temp.substring(1)).append(temp.charAt(0));
            temp = new StringBuilder(sb);
            System.out.println(temp);
        }
    }

        // 방법 1. 0부터 n-1까지 loop
//         rotation할 때 마다, 임시의 string의 두번째 글자를 복사하고, 기존 string의 첫 글자를 temporary String에 복사한다
    static void printRotatedString2(String str) {
        StringBuilder sb;

        for (int i = 0; i < str.length(); i++) {
            sb = new StringBuilder();
            int strIndex = i;   // Current index in str
            int tempIndex = 0;  // Current index in temp

            // string에서 second part from point of rotation을 복사해서 sb 붙히기.
            for (int j = strIndex; j < str.length(); j++) {
                sb.insert(tempIndex, str.charAt(strIndex));
                tempIndex++;
                strIndex++;
            }
            // string에서 first part from point of rotation을 복사해서 sb에 붙히기.
            strIndex = 0;
            for (int j = strIndex; j < i ; j++) {
                sb.insert(tempIndex, str.charAt(j));
                tempIndex++;
            }
            System.out.println(sb);
        }
    }


    // 방법 2. 같은 string을 두개 붙혀서 잘라주기.
    static void printRotatedString3(String str){
        StringBuilder sb = new StringBuilder(str);
        // str에 str을 붙혀 str두개를 이음.
        sb.append(str);
        System.out.println("sb = " + sb);
        //sb size는 2n
        for (int i = 0; i < str.length() ; i++) {
            // j가 str.length 길이랑 같을때 까지.
            for (int j = 0; j < str.length() ; j++) System.out.print(sb.charAt(i + j));
            System.out.println();
        }
    }
    // 위 방법을 substring으로 변환
    static void printRotatedString4(String str){
        StringBuilder sb = new StringBuilder(str);
        // str에 str을 붙혀 str두개를 이음.
        sb.append(str);
        System.out.println("sb = " + sb);
        //sb size는 2n
        for (int i = 0; i < str.length() ; i++) {
            System.out.println(sb.substring(i,i+5));
        }
    }
    public static void main(String[] args) {
        String  str = new String("geeks");
        printRotatedString(str);
    }
}

