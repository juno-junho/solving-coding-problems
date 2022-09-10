import java.util.HashMap;
import java.util.Scanner;

// 모든 아나그램 찾기
// 헤맨이유 : 둘 map 비교 하는것 equals로 하는지 몰랐음.
class HashMap4 {
    int solution(String s1, String s2) {
        // s1에서 s2와 아나그램 되는 부분 문자열 개수
        // s2의 길이만큼 sliding window로 돌아야 한다. 돌면서 아나그램 체크하기
        // 처음 k-1 까지 인덱스 체크하고, rt가 k-1 부터 돌면서 lt 빼고 rt 더해서 두 map 비교
        int answer = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char x : s2.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        HashMap<Character, Integer> map2 = map1;
        for (int i = 0; i < s2.length() - 1; i++) {
            if (map2.get(s1.charAt(i)) == 0) {
                map2 = map1;
                continue;
            }
            map2.put(s1.charAt(i), map2.get(s1.charAt(i)) - 1);
        }
        int lt = 0;
        for (int rt = s2.length() - 1; rt < s1.length(); rt++) {
            if (map2.isEmpty()) {
                answer++;
                map2 = map1;
            }
            if (map2.get(s1.charAt(rt)) == 0) {
                map2 = map1;
                continue;
            }
            map2.put(s1.charAt(rt), map2.getOrDefault(s1.charAt(rt), 0) + 1);
            //비교
            if(map1.equals(map2)) answer++;
            //빼기
            map2.put(s1.charAt(lt), map2.get(s1.charAt(lt)) - 1);
            if (map2.get(s1.charAt(lt)) == 0) map2.remove(s1.charAt(lt));
            lt++;
        }


        return answer;
    }
    //강사 풀이
    int solution1(String a, String b) {
        int answer = 0;
        // b 세팅
        int length1 = a.length();
        int length2 = b.length();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (int i = 0; i < length2; i++) bm.put(b.charAt(i), bm.getOrDefault(b.charAt(i), 0) + 1);

        // b 문자열 -1 까지 세팅 (sliding window를 위해서)
        HashMap<Character, Integer> am = new HashMap<>();
        for (int i = 0; i < length2 - 1; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);

        int lt = 0;
        for (int i = length2 - 1; i < length1; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);

            //비교
            if(am.equals(bm)) answer++;

            //빼기
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        HashMap4 T = new HashMap4();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution1(s1, s2));
    }
}
