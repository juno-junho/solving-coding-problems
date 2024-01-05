import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming6 {

    /**
     * 최대 점수 구하기
     * 현수는 선생님이 주신 N개의 문제를 풀려고 한다.
     * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 된다.
     * 제한시간 M안에 N개의 문제 중 최대 점수를 얻을 수 있도록 해야 한다.
     * (해당 문제는 해당 시간이 걸리면 푸는 걸로 간주한다, 단 유형당 한개만 풀 수 있다.)
     *
     * 입력 :
     * 첫 번째 줄: 문제의 개수 N과 제한시간 M
     * 두 번째 줄: N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간
     * 5 20 (5문제, 총 20분)
     * 10 5 (점수 / 걸리는 시간) -> 한개 밖에 없는 것.
     * 25 12 //
     * 15 8
     * 6 3
     * 7 4

     * 출력 : 41 (최대 점수)
     * -> 핵심은 문제가 한문제만 적용하게 될 수 있다.
     * napsack 알고리즘 -> 종류가 무한이면 앞에서
     * 종류가 한개만 존재한다 (유한개) -> 뒤에서 부터 앞으로
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int problemCount = Integer.parseInt(input[0]);
        int timeLimit = Integer.parseInt(input[1]);

        int[] dy = new int[timeLimit + 1]; // 20분 -> 21칸의 배열 만들기

        for (int i = 0; i < problemCount; i++) {
            String problemInput = bf.readLine();
            String[] problemInfo = problemInput.split(" ");

            int problemScore = Integer.parseInt(problemInfo[0]);
            int solvingTime = Integer.parseInt(problemInfo[1]);

            for (int j = timeLimit; j >= solvingTime; j--) {
                dy[j] = Math.max(dy[j], dy[j - solvingTime] + problemScore);
            }
        }
    }
}
