import java.util.HashMap;

// 핵심은 경우의수. 수학이다. 옷을 안입는 경우를 + 1 해서 생각하기.
// stream으로 풀어보기.
public class Camouflage {
    static int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) map.put(clothe[1],map.get(clothe[1])+1);
            else map.put(clothe[1],1);
        }
        // 조합이 필요하다
        // key - value로 이루어진 것을 하나씩만 입는 경우, 두가지를 입는 경우, 세가지를 입는경우 ... map.size()만큼 입는 경우
        int count = 1;
        if (map.size() > 1){
            for (String s : map.keySet()) {
                count *= map.get(s) + 1;
            }
            count --;
        }else {
            count = clothes.length;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{}));

    }
}
