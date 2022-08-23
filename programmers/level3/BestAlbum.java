import java.util.Collections;
import java.util.HashMap;

public class BestAlbum {
    static int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> map = new HashMap<>();
        // hash로 genre - 총 재생횟수. 만들기.
        for (int i = 0; i < genres.length; i++) {
//            map.put(genres[i],map.getOrDefault(genres[i],map.g))
            if (map.containsKey(genres[i])) map.put(genres[i], map.get(genres[i]) + plays[i]);
            else map.put(genres[i], plays[i]);
        }
        int[] answer = {};
        return answer;
    }
}
