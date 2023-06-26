package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {

    /**
     * 개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
     * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
     * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
     * 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
     */
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
        solution(nArr, mArr);
    }

    private static void solution(int[] nArr, int[] mArr) {
        // 이분 탐색할때는 st와 en 두 변수가 필요하다 mid = (st + en) /2
        // st와 en 이 역전되면 값이 없는 것이다.
        for (int num : mArr) {
            // num이 nArr에 포함 되어 있냐 없냐
            if (binarySearch(nArr, num) == -1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

    }

    private static int binarySearch(int[] mArr, int num) {
        int start = 0;
        int end = mArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (num == mArr[mid]) {
                return mArr[mid];
            }
            if (num > mArr[mid]) {
                start = mid + 1;
            }
            if (num < mArr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
