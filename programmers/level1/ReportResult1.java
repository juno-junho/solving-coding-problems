import java.util.*;
import java.util.stream.Collectors;

public class ReportResult1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // report를 list로 만들기
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        //
        HashMap<String,Integer> count = new HashMap<>();
        // list를 돌면서 신고댱햔 사람(target)과 신고 당한 수를 넣는다 (count map)
        for (String str: list) {
            String target = str.split(" ")[1];
            count.put(target, count.getOrDefault(target,0) + 1);
        }

        // 이 밑에것을 이해 못함.
        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            // report를 list로 만든것에서 id_list에 있는 id로 시작하는것의 list.
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s-> count.getOrDefault(s.split(" ")[1], 0) >=k).count();
        }).mapToInt(Long::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        ReportResult1 re = new ReportResult1();
        System.out.println(Arrays.toString(re.solution(id_list, report, 2)));

    }
}
