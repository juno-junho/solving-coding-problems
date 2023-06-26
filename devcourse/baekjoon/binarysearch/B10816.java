package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 {
    /**
     * 숫자 카드는 정수 하나가 적혀져 있는 카드이다.
     * 상근이는 숫자 카드 N개를 가지고 있다.
     * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
     *
     */

    private static int[] solution(int[] nArr, int[] mArr) {
        // nArr은 정렬이 되어 있음.
        // mArr 하나씩 꺼내서 이분탐색으로 계산하기
        int[] answer = new int[mArr.length];
        int index = 0;
        for (int num : mArr) {
            answer[index++] = getCount(nArr, num);
        }
        return answer;
    }

    /**
     * 몇 번 나오는지 확인
     * 이분 탐색으로 나오는 index는 어디가 될지 모른다.
     * 시도 1. 값이 같은 값 (target)일때 까지 오른쪽으로 이동 -> 왼쪽으로 이동 => target 개수에 비례해 시간 걸림. 최악의 경우 배열에 있는 모든 수가 같으면 O(n)
     * 시도 2. 오른쪽, 왼쪽 끝을 어떻게든 구하면 된다
     * 특정 값을 삽입하여도 오름차 순 순서가 유지되려면 크기가 같은 인덱스에 들어가거나 최초로 특정 값보다 큰 수가 등장하는 자리에 들어갈 수 있다.
     * => 삽입할 수가 주어질 때 오름차순 순서가 유지되는 가장 왼쪽 위치와 오른쪽 위치를 이분탐색으로 구할 것이다.
     * => 삽입할 수 있는 곳 : 0 ~ length 까지 (length -1 아님)
     */
    private static int getCount(int[] nArr, int num) {
        int lowerBound = getLowerBound(nArr, num);
        int upperBound = getUpperBound(nArr, num);
        return upperBound - lowerBound;
    }

    private static int getLowerBound(int[] nArr, int num) {
        int start = 0;
        int end = nArr.length;
        while (start < end) {
            int mid = (start + end) / 2;

            if (nArr[mid] >= num) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int getUpperBound(int[] nArr, int num) {
        int start = 0;
        int end = nArr.length;
        while (start < end) {
            int mid = (start + end) / 2;

            if (nArr[mid] > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int[] nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);
        int M = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());
        int[] mArr = new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st2.nextToken());
        }
        int[] answer = solution(nArr, mArr);
        StringBuilder sb = new StringBuilder(2 * mArr.length);
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
