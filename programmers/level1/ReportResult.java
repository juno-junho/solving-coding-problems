import java.util.*;
// 후기 : stream 확실히 공부하기.
public class ReportResult {
    /*
     불량 이용자 신고 -> 처리결과 메일로 발송
      - 각 유저는 한번에 한명의 유저 신고 (신고 횟수 제한 x, 서로다른 유저 계속 신고 가능)
      - 한 유저 여러번 신고 가능하지만, 동일한 유저에 대한 신고 횟수는 1회로 처리
      - k번 이상 신고된 유저는 게시판 이용 정지, 유저를 신고한 모든 유저에게 정지 사실 메일 발송
      - 유저가 신고한 모든 내용 취합해 마지막에 한번에 게시판 이용정지 시키며 메일 발송.
     */

    // id 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 id 정보가 담긴 문자열 배열 report, 정지 기준 신고횟수 k
    // 각 유저별로 처리 결과 메일 받은 횟수를 배열에 담아 return.
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //1. report를 신고한 id와 신고당한 id를 표로 만들기.
        //2. id를 key로(신고한 사람), 신고당한 사람을 set을 value로 하는 hashmap 만들어서 report 쪼개서 하나하나 넣기.
        //3. id당 신고당한 횟수 hashmap으로 만들기 (중복 제거 해주기)
        //4. id 중 k번이상 신고 된 사람을 set으로 가지고 있는 key인 id에게 숫자 ++ 해서 answer 넣기.

        //2. id를 key로(신고한 사람), 신고당한 사람을 set을 value로 하는 hashmap 만들어서 report 쪼개서 하나하나 넣기.
        Map<String, Set<String>> report_list = new HashMap<String,Set<String>>();
        // id와 누구를 신고했는지에 대한 list.
        for (String str:report) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            Set<String> report_set = new HashSet<>();
            String id = stringTokenizer.nextToken();
            String reportedId = stringTokenizer.nextToken();
            // 이름이 같으면 같은 report_set가져 와야함.
            if (report_list.containsKey(id)){
                Set<String> idSet = report_list.get(id);
                idSet.add(reportedId);
            }else {
                report_set.add(reportedId);
                report_list.put(id, report_set);
            }
        }

//        report_list.forEach((key,value) -> System.out.println(key + " : " + value));

        // k번 이상 신고당한 id list
        List<String> blocked_id = new ArrayList<>();
        //3. id당 신고당한 횟수 hashmap으로 만들기 (중복 제거 해주기)
        Map<String, Integer> reportNum = new HashMap<>();
        for (String id:id_list) {
            int count =0;
            Collection<Set<String>> values = report_list.values();
            for (Set<String> set:values) {
                if(set.contains(id)) count++;
            }
            if (count >= k) blocked_id.add(id);
            reportNum.put(id, count);
        }

        blocked_id.forEach(System.out::println);
        //4. id 중 k번이상 신고 된 사람(blocked_id)을 set으로 가지고 있는 key인 id에게 숫자 ++ 해서 answer 넣기.
        // report_list에서 각 set에 blocked_id 포함 되어 있으면 그 key인 id에게 숫자 ++.
        // id_list 맞게끔 answer에 그 값(숫자)를 넣으면 됨.
        int i = 0;
        for (String id : id_list) {
            int count = 0;
            for (String blockedId : blocked_id) {
                if (report_list.containsKey(id) && report_list.get(id).contains(blockedId)) count++;
            }
            System.out.println(id + " :: " + count);
            answer[i] = count;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        ReportResult re = new ReportResult();

        Arrays.toString(re.solution(id_list,report,2));

    }
}
