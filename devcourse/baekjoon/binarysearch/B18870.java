package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class B18870 {

    private static int[] solution(int n, int[] nArr) {
        int[] clone = nArr.clone();
        Arrays.sort(clone);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i : clone) {
            linkedHashSet.add(i);
        }
        clone = linkedHashSet.stream().mapToInt(i -> i).toArray();
        int[] answer = new int[n];
        int index = 0;
        for (int num : nArr) {
            int result = binarySearch(clone, num);
            answer[index++] = result;
        }
        return answer;
    }

    private static int binarySearch(int[] arr, int num) {
        // 찾은 최초의 num의 index를 반환하면 된다.
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= num) {
                end = mid;
            }else {
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
        int[] answer = solution(N, nArr);
        StringBuilder sb = new StringBuilder(2 * nArr.length);
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
