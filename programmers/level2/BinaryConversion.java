import java.util.stream.Stream;

public class BinaryConversion {
    public int[] solution(String s) {

        // s에서 0제거. (스트림 사용 o) -> 1개수를 이진수로
        int removedZeroNum = 0;
        int conversionNum = 0;

        while (!s.equals("1")){
            for (char c : s.toCharArray()) {
                if (c == '0') removedZeroNum++;
            }
            s = s.replace("0","");
//            long count = s.chars().filter(i -> i == '1').count();
//            removedZeroNum+= s.chars().filter(i -> i == '0').count();
            s = Long.toBinaryString(s.length());
            conversionNum++;
        }


        int[] answer = {conversionNum, removedZeroNum};
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(4));
        String s = "0111010";
        String replace = s.replace("0", "");
        System.out.println(replace);
//        long count = s.chars().filter(i -> i == '1').count();
//        System.out.println(count);
    }
}

