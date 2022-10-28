//import java.util.Stack;
//
//public class Problem2_test {
//    public static String solution(String cryptogram) {
//        StringBuilder sb = new StringBuilder(cryptogram.length());
//
//        // 1. index1, index2 찾아서 같으면 삭제한다.
//        // 2. 삭제하고 index1은 1 줄인다.
//        // 3. index2 = index1 + 1
//        // 4. index2 >= length-1 && index1 >= length-2 이면 while문 끝.
//
//        char[] letters = cryptogram.toCharArray();
//        int index1 = 0;
//        int index2 = 1;
//        boolean flag = false;
//        while (index1 < letters.length - 1 || index2 < letters.length - 2) {
//
//            if (cryptogram.charAt(index1) == cryptogram.charAt(index2)) {
//                flag = true;
//            }
//            if (flag) index2++;
//            if (!flag){
//                index
//            }
//        }
//
//
//
////        sb.replace(index1, index2, "");
//        while ()
//        for (int i = 0; i < letters.length; i++) {
//            if (!flag && letters[i] == letters[i - 1]) {
//                index1 = i- 1;
//                flag = true;
//            }
//            if (flag && letters[i - 1] != letters[i]) {
//                index2 = i - 1;
//                sb.replace(index1, index2, "");
//                break;
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//
//        System.out.println(Problem2_test.solution("zyellleyz"));
//
//    }
//
//}
