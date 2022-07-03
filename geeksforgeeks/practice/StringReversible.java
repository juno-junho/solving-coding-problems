public class StringReversible {
    // string이 대칭적인지 확인.
    static boolean isReversible1(String str){
        // string 뒤집은 것이 str과 같은지 확인
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString().equals(str);
    }
    static boolean isReversible2(String str) {
        //string str이 주어졌을때, str의 substring의 모든 reverses가 str에 있는지 없는지.
        // string이 palindrome이냐 아니냐
        int i = 0;
        int j = str.length()-1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
//        for (int k = 0; k < str.length() ; k++) {
//            if (str.charAt(k) != str.charAt(str.length()-1-k)) return false;
//        }
//        return true;
    }
    public static void main(String[] args) {
        String str = "aba";
        if (isReversible1(str))
            System.out.print("YES");
        else
            System.out.print( "NO");
    }
}
