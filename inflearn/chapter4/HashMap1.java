import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMap1 {
    private String solution(int n, String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) == max) return character.toString();
        }
        return "0";
    }

    public static void main(String[] args) {
        HashMap1 T = new HashMap1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(T.solution(n, s));
    }
}
