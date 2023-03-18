package freecourse.week1;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    // 두 글자 이상의 문자가 연속적으로 순서에 맞춰 포함되어 있는 경우 중복으로 간주.
    // 닉네임은 한글로만 가능. 1자 이상 20자 미만.
    // result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬, 중복 제거.

    // 이름을 저장해고 비교를 해야 한다.  ->
    //
    // hashmap에 Integer, String으로 저장하고 result에
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        // 이름 , 이메일(중복가능)
        Map<String, String> nickname = new HashMap<>();

        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                nickname.put(form.get(1), form.get(0));
            }
        }
        Set<String> nicknameList = nickname.keySet();
        nicknameList.forEach(i -> {
            for (int j = 0; j < i.length() - 1; j++) {
                String substring = i.substring(j, j + 2);
                nicknameList.forEach(k -> {
                    if (!k.equals(i) && k.contains(substring)) result.add(nickname.get(k));});
            }
        });
        return result.stream().distinct().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        List<String> solution = Problem6.solution(forms);
        System.out.println(solution);

    }
}