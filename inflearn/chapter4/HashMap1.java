import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMap1 {
    String solution(int n, String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
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
    // 강사 풀이
    char solution1(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character x : map.keySet()) {
            if (map.get(x) > max){
                max = map.get(x);
                answer = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HashMap1 T = new HashMap1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(T.solution(n, s));
    }
}
