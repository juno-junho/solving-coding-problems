import java.util.*;
import java.util.stream.Collectors;

public class IncompletedRunner {
// list.remove()는 처음 요소 하나만 제거 한다. 모두 제거. foreach안에서 remove같은 함수 쓰면 ConcurrentModificationException 발생.
    // list에서 중복을 제거하는 방법 : 1.set 이용, 2.distinct() 이용
    // list에서 중복값 찾는 법 : https://developer-talk.tistory.com/398
    static String solution(String[] participant, String[] completion) {
        // completion에 이름 없는 사람들 participant에서 빼는데, 동명이인 있을 수 있다.
        // 근데 한명 밖에 없다. completion 길이가 participant 보다 1 작다.
//        Set<String> distinct = new HashSet<>();
//
//        Stream.of(participant).filter(i -> !distinct.add(i)).findFirst().orElse("Error");
//        List<String> list = Stream.of(participant).filter(i -> Stream.of(completion).noneMatch(i::equals)).collect(Collectors.toList());
//        if (list.size() == 0){
//            // participant에서 중복된 값 제거.
//            return Stream.of(participant).filter(i -> !distinct.add(i)).findFirst().orElse("Error");
//
//
//        }
//
//        return list.get(0);
        // 위에 stream은 동명이인, 즉, participant와 completion을 1:1로 지우지 못함.
//

        Map<Integer,String> map = new HashMap<>();

        return "a";
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        solution(participant, completion);


    }
}
