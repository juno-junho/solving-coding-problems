import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearningWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
//        // 배열에서 가장 많은 값 출력하는 방법
//
//        // Optional로 받은 다음 여러개일 경우 ? orElse()로 ? 출력
//
//        // 1. String[] 돌면서 요소마다 배열 돌면서 배열 요소와 같으면 +1. 가장 값것 -> 여러개인것 구별 불가능
//        // 2. set으로 만든 다음 요소마다 가장 많은것 -> 대문자로 반환. 아니면 ? 반환
//
//        String[] stringArray = word.split("");
//        Set<String> stringSet = Stream.of(stringArray).collect(Collectors.toSet());
//        stringSet.forEach();
//        HashMap<String, Integer> stringMap = new HashMap<>();
//        for (String alphabet:stringSet) {
//            int count = 0;
//            for (String eachWord:stringArray) {
//                if(alphabet.equals(eachWord)) count++;
//            }
//            stringMap.put(alphabet,count);
//        }
//        //Map에서 가장 큰 count -> 대문자로 출력
//        List<String> stringList = new ArrayList<>();
//        OptionalInt max = stringMap.keySet().stream().mapToInt(Integer::new).max();
//        for (String alphabet:stringSet) {
//            if(stringMap.get(alphabet).equals(max.orElse(0))){
//                stringList.add(alphabet);
//            }
//        }
//        if (stringList.size() > 1) System.out.println("?");
//        else System.out.println(stringList.get(0));
    }
}
