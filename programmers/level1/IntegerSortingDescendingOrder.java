import java.util.Arrays;
import java.util.Comparator;

public class IntegerSortingDescendingOrder {
    // stream 이해 하기.
    String res = "";
    public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = (char) c + res);
        return Integer.parseInt(res);
    }
    public long solution2(long n) {
        return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }
    static long solution(long n) {
        // n을 쪼개서 배열로 만든다음에 sorting한다.
//        long num = n;
//        int digits = 0;
//        while (num > 0){
//            num /= 10;
//            digits++;
//        }
//
//        long[] arr = new long[digits];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = n % 10;
//            n /= 10;
//        }
        char[] c = String.valueOf(n).toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder(new String(c,0,c.length));
        long answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }

    public static void main(String[] args) {
        System.out.println( solution(118372));
    }

}
