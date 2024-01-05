import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class DynamicProgramming3 {

    /**
     * 최대 부분 증가 수열
     * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는 원소들의 집합을 찾는 프로그램을 작성해라
     * 원소가 2,7,5,8,6,4,7,12,3 -> 가장 길게 증가하도록 원소들을 차례대로 뽑아내면
     * 2,5,6,7,12를 뽑아내 길이가 5인 최대 부분 증가수열을 만들 수 있다.
     */

    private static int[] dy;

    public int solution(List<Integer> inputs) {
        int answer = 0;
        dy = new int[inputs.size()];
        dy[0] = 1;
        for (int i = 1; i < inputs.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (inputs.get(i) > inputs.get(j) && dy[j] > max) {
                    max = dy[j];
                }
                dy[i] = max + 1;
                answer = Math.max(answer, dy[i]);
            }
        }
        return answer;
    }

    public int mySolution(List<Integer> inputs) {
        int answer = 0;
        dy = new int[inputs.size()];
        dy[0] = 1;
        for (int i = 1; i < inputs.size(); i++) { // dy[i]값을 채워준다!!
            // 만약 arr[i-1] < arr[i] 면 dy[i] = dy[i-1] + 1
            // 아니면 arr[i]보다 값이 작은 arr[i-x]에서의 dy[i-x] + 1 값
            int max = 0; // 이 max 값을 해주는 이유 : j를 순회하는데 dy[j]의 max 값 + 1를 해주어야 하기 때문!!!
            for (int j = i - 1; j >= 0; j--) { // 최댓값 구하기 위해서 도는 것.
                if (inputs.get(j) < inputs.get(i) && dy[j] > max) { // 그래서 max보다 dy[j]가 작거나 같으면 넘어가도 된다.
                    max = dy[j];
//                    dy[i] = dy[i - 1] + 1; // 근데 여기서 최댓값일때만 더해줘야 한다..! 그래서 아래와 같이 max로 설정해주고 dy[i]에 할당
                }
            }
            dy[i] = max + 1; // 그래서 max를
            answer = Math.max(answer, dy[i]);
        }
        return answer;

    }


    public static void main(String[] args) throws IOException {
        DynamicProgramming3 main = new DynamicProgramming3();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int n = Integer.parseInt(input);
        String inputArrayStrings = bf.readLine();
        List<Integer> inputs = Arrays.stream(inputArrayStrings.split(" ")).map(Integer::parseInt).toList();
        System.out.println(main.solution(inputs));

        // dy[i]는 i번째 숫자를 마지막 항으로 하는 최대 증가 수열의 길이
        /**
         *
         *5 3 7 8 6 2 9 4
         * dy[0] = 1; // 5
         * dy[1] = 1; // 3
         * dy[2] = 2 // 3 7 or 5 7
         * dy[3] = 3 // 3 7 8 or 5 7 8 // dy[2]에 + 1 한 값 = 3
         * dy[4] = 2 // 5 6 or 3 6 //
         * dy[5] = 1 // 2
         * dy[6] = 4 // 5 7 8 9 or 3 7 8 9 or 7 8 9
         * ...
         * dy[i] = // 만약 arr[i]가 가장 큰 곳의 dy[i] 수?
         * // 만약 arr[i-1] < arr[i] 면 dy[i] = dy[i-1] + 1
         * 아니면 arr[i]보다 값이 작은 arr[i-x]에서의 dy[i-x] + 1 값
         *
         */
    }

}
