import java.util.Arrays;
import java.util.Comparator;

public class PhoneBook {
    static boolean solution(String[] phone_book) {
        // 정렬 -> 짧은것(배열 앞쪽)이 긴것(배열 뒷쪽)에서 처음에 시작하는지 확인.
        // 정렬한다.
        boolean answer = true;
//        Arrays.sort(phone_book, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });


//        for (int i = 0; i < phone_book.length; i++) {
//            for (int j = phone_book.length-1; j >= 0 ; j--) {
//                if ( i == j) break;
//                if(phone_book[j].startsWith(phone_book[i])) return false;
//            }
//        }
        // sort하면 양옆만 확인하면 된다.

        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"123","456","789"}));
    }
}
