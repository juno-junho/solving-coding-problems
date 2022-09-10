import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HashMap2 {
    String solution(String s1, String s2){
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Character character : map1.keySet()) {
            if (map1.get(character) != map2.get(character)) return "NO";
        }
        return "YES";
    }

    // 강사풀이
    String solution1(String s1, String s2) {
        // 첫 문자열을 map에 넣고 두 번째 문자열로 map에서 지우기. -> value빼기전 0이면 return false. 없어도 false
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        HashMap2 T = new HashMap2();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1, s2));
    }
}
