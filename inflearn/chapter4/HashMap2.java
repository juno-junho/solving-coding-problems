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

    public static void main(String[] args) {
        HashMap2 T = new HashMap2();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1, s2));
    }
}
