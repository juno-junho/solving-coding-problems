import java.util.StringTokenizer;
// 정규식에 대한 학습 필요.
public class DartGame {
    // 다트 3번 던진다.
    // 각 기회마다 얻을 수 있는 점수는 0~10점
    // 점수와 함께 S D T 영역 존재. 각 영역 당첨시 점수에서 1제곱 2제곱 3제곱
    // * : 스타상 / # : 아차상. 스타상 당첨 시 해당 점수와 바로 전에 얻은 점수를 두 배로 만든다. 아차상 당첨시 해당 점수 마이너스
    // 단 첫번째 기회에 스타상 나오면 첫번째 스타상 점수만 2배가 됨.
    // 스타상은 다른 스타상과 중첩가능. 그러면 4배됨. ex) 첫번째 스타상, 두번째도 스타상이면 첫번째는 네배가됨.
    // 스타상과 아차상 중첩 경우 아차상 점수 -2배
    // S D T 는 0~10 점까지 점수마다 하나ㅣ씩 존재.
    // 스타상 / 아차상은 점수마다 둘중 하나만 존재 or 하나도 존재 하지 않음.
    static int solution(String dartResult) {
        // 숫자 + 보너스 + 옵션(있을수도 없을수도)
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        String[] split = dartResult.split("[*|#]");
        for (String s : split) {
            System.out.println(s);
        }
    }

}
