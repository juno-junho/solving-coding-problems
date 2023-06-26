package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18869 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[M][N];
        for (int i = 0; i < matrix.length; i++) {
            StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int answer = solution(matrix);
        System.out.println(answer);
    }

    private static int solution(int[][] matrix) {

        for (int[] universe : matrix) {
            int[] clone = universe.clone();
            Arrays.sort(clone);

            for (int j = 0; j < universe.length; j++) {
                int index = binarySearch(clone, universe[j]);
                universe[j] = index;
            }
        }

        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (Arrays.equals(matrix[i], matrix[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static int binarySearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] > num) {
                end = mid - 1;
            }
            if (arr[mid] < num) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
