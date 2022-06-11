import java.util.*;
import java.util.stream.Collectors;

// Stream에서 함수형 인터페이스를 완전히 이해하지 못해 코드 이해 못했던 것.
// 함수형 인터페이스의 구조와 람다식 사용 방법을 숙지할 필요가 있다 ...
public class ReportResult1 {
    public void solution(String[] id_list, String[] report, int k) {
        // report를 list로 만들기
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());

        HashMap<String,Integer> count = new HashMap<>();
        // list를 돌면서 신고댱햔 사람(target)과 신고 당한 수를 넣는다 (count map)
        for (String str: list) {
            String target = str.split(" ")[1];
            count.put(target, count.getOrDefault(target,0) + 1);
        }
        int[] s1 = Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            // report를 list로 만든것에서 id_list의 id대로 돌며 report한것 확인한 다음에 신고당한 사람이 k이상 신고 된 개수를 array로 만드는 것.
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(i -> i.intValue()).toArray();
        Arrays.stream(s1).forEach(System.out::println);
        // 이 밑에것을 이해 못함.
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        ReportResult1 re = new ReportResult1();
        re.solution(id_list, report, 2);


    }
}
