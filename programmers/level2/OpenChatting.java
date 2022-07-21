import java.util.*;

public class OpenChatting {
    //풀이시간 : 25분 정도 걸림.
    static String[] solution(String[] record) {
        // 닉네임 변경법 :
        // 1.채팅방 나가고 새로운 이름으로 다시 들어가거나,
        // 2.채팅방에서 닉네임 변경
        // -> 기존 출력된 메세지 닉데임도 전부 변경
        Map<String, String> map = new HashMap<>();
        // 접근 방식 : map에 id, name을 key : value로 저장. (enter, Change로 시작할떄)
        // 키워드로 접근. change id -> map에 있는 id에 name 모두 바꾼다. (change나오면 어차피 덮어씀)
        // 키워드 + id로 map과 연력해서 answer배열에 하나씩 넣기.

        for (String value : record) {
            String[] eachString = value.split(" ");
            if (eachString[0].equals("Enter") || eachString[0].equals("Change")) {
                map.put(eachString[1], eachString[2]);
            }
        }
        List<String> answerList = new ArrayList<>();
        for (String s : record) {
            String[] eachString = s.split(" ");
            // enter로 시작경우
            if (eachString[0].equals("Enter")) answerList.add(map.get(eachString[1]) + "님이 들어왔습니다.");
            // Leave로 시작 경우
            if (eachString[0].equals("Leave")) answerList.add(map.get(eachString[1]) + "님이 나갔습니다.");
        }
        String[] answer = answerList.stream().map(Object::toString).toArray(String[]::new);
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(arr)));
    }
}
