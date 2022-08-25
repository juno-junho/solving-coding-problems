import java.util.Arrays;

public class MaxAndMin {
    String solution2(String s){
        String[] s1 = s.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(s1[0]);
        for (int i = 1; i < s1.length; i++) {
            n = Integer.parseInt(s1[i]);
            if (min > n ) min = n;
            if (max < n) max = n;
        }
        return min + " " + max;
    }

    public String solution(String s) {
        String[] s1 = s.split(" ");
        int maxNum = Arrays.stream(s1).mapToInt(Integer::parseInt).max().getAsInt();
        int minNum = Arrays.stream(s1).mapToInt(Integer::parseInt).min().getAsInt();
        return minNum + " " + maxNum;

    }
}
