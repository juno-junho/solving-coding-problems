import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicProgramming4 {

    /**
     * 가장 높은 탑 쌓기
     * 밑면이 정사각형인 직육면체 벽돌들을 사용해 탑을 쌓고자 한다.
     * 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
     * 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오
     *
     * 1. 벽돌은 회전 못시킨다. 즉 옆면을 윗면으로 사용 못한다
     * 2. 밑면의 넓이가 같은 벽돌은 사용 못한다. 무게가 같은 벽돌도 없다.
     * 3. 벽돌들의 높이는 같을 수도 있다.
     * 4. 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
     * 5. 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
     *
     * 입력 설명
     * 입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다.
     * 입력으로 주어지는 벽돌의 수는 최대 100개다.
     * 둘째 줄 부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌의 밑면의 넓이, 벽돌의 높이, 무게가 차례대로 양의 정수로 주어진다.
     * 각 벽돌은 입력되는 순서대로 1 부터 연속적인 번호를 가진다.
     * 벽돌의 넓이, 높이, 무게는 10,000보다 작거나 같은 자연수이다.
     *
     */

    private static int[] dy;

    public int solution(List<Brick> bricks) {
        Collections.sort(bricks);

        dy = new int[bricks.size()];
        dy[0] = bricks.get(0).getHeight();
        int answer = dy[0];

        for (int i = 1; i < bricks.size(); i++) { // dy[i]를 구한다.
            // 무게를 비교햔다
//            int max = dy[0];
            int max = 0;
            for (int j = i - 1; i >= 0; i--) {
                if (bricks.get(i).getWeight() < bricks.get(j).getWeight() && dy[j] > max) { // 일단 더 가벼운게 쌓여야한다. -> dy[j]가 최대인것 + 지금의 높이
                    max = dy[j];
                }
            }
            dy[i] = max + bricks.get(i).getHeight();
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        DynamicProgramming4 main = new DynamicProgramming4();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int n = Integer.parseInt(input); // 벽돌 개수
        List<Brick> bricks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String inputArrayStrings = bf.readLine();
            String[] infos = inputArrayStrings.split(" ");
            int width = Integer.parseInt(infos[0]);
            int height = Integer.parseInt(infos[1]);
            int weight = Integer.parseInt(infos[2]);
            bricks.add(new Brick(width, height, weight));
        }
        // 내림차순 이유 : 밑면으로는 무조건 올라갈 수 있다. 무게만 보면 된다.
        System.out.println(main.solution(bricks));
    }

    static class Brick implements Comparable<Brick> {

        private final int width;
        private final int height;
        private final int weight;

        private Brick(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public int compareTo(Brick o) {
            return o.width- this.width;
        }
    }

}
