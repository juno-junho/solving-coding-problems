import java.util.*;

public class Tuple {

    public int[] solution(String s) {

        s = s.replace("},{", " ");
        s = s.substring(2, s.length() - 2);
        String[] s1 = s.split(" ");

        Arrays.sort(s1, (String a, String b) -> a.length() - b.length());
        List<Integer> list = new ArrayList<>();
        for (String s2 : s1) {
            if (s2.contains(",")) {
                String[] split = s2.split(",");
                for (String s3 : split) {
                    int num = Integer.parseInt(s3);
                    if (!list.contains(num)) list.add(num);

                }
            } else list.add(Integer.parseInt(s2));
        }

        int[] answer = new int[s1.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {



    }
}
