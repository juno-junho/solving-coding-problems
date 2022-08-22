import java.util.*;

// 핵심은 비교하는 방법. o1과 o2를 더한 다음 Integer로 변환해 비교하는 것.
public class BiggestNumber {
    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }
    static String solution(int[] numbers) {
//        if (Arrays.stream(numbers).sum() == 0) return "0";
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
    // 처음 내가 생각한 방식 : 10의 자리의 수로 나누고.. 뭐 그렇게 비교..

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Integer.parseInt(o1 + o2);
                int i2 = Integer.parseInt(o2 + o1);

                return i1-i2;
            }
        });

        System.out.println(Arrays.toString(strings));

        String answer = "";
        for (int i = strings.length -1 ; i >= 0; i--) {
            answer += strings[i];
        }
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }

    public static void main(String[] args) {
        System.out.println( solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{0,1,3,4,5}));

    }
}
