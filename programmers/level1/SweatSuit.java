import java.util.ArrayList;
import java.util.List;
// hashset으로 풀어보기.
// 푸는데 상당히 시간이 걸린 문제.
// 배열을 이용하는 방법 good

public class SweatSuit {
    private static int solution(int n, int[] lost, int[] reserve) {
        // 전체 학생 수 : n / 체육복 도난당한 학생 번호 담긴 배열 lost / 여벌의 체육복 가져온 학생들의 번호 담기 배열 reserve
        // 체육수업 들을 수 있는 학생 최댓값 return/ 번호 앞뒤로 밖에 못빌려줌.
        // 최솟값 : n - lost.length
        // lost - reserve 차이가 1나면 그만큼 + 해주면 되는거 아닌가
        int answer = n - lost.length;
        List<Integer> list = new ArrayList<>();
        for (int i : reserve) {
            for (int i1 : lost) {
                if(i == i1) list.add(i);
            }
        }
        // reserve와 lost에서 같으면 아예 lost에서 제거를 해줘야 한다.
        for (int i : reserve) {
            if (list.contains(i)){
                answer++;
                continue;
            }
            for (int i1 : lost) {
                if (list.contains(i1))continue;

                if(Math.abs(i-i1) == 1) {
                    answer++;
                    break;
                }
            }
        }
        if (answer > n) answer = n;
        return answer;
    }
    private static int solution2(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] people = new int[n]; // 0으로 초기화
        for (int i : lost) people[i-1] --;
        for (int i : reserve) people[i-1] ++;
        // 이제 -1인 index+1이 체육복 없는 사람임.
        // +1이면 index+1이 체육복 있는 사람들.
        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1 ) {
                if (i >=1 && people[i-1] == 1){
                    people[i-1]--;
                    people[i] ++;
                }else if (i+1<people.length && people[i+1] == 1){
                    people[i+1] --;
                    people[i] ++;
                }else answer--;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        // 3 4 6
        System.out.println(solution2(10, new int[]{3,9,10}, new int[]{3,8,9}));
    }
}
