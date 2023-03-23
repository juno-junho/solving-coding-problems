import java.util.Arrays;

public class Algorithms1 {

    /**
     * n 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수를 작성해라.
     * n은 10만 이하의 자연수
     */
    // O(N)
    static int func1(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                count += i;
            }
        }
        return count;
    }

    /**
     * 길이 n의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1, 않으면 0 반환하는 함수 func2 작성
     * arr의 각 수는 0 이상 100 이하, n은 1000이하
     */
    // O(N^2)
    static int func2(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // O(N)
    static int func2_1(int[] arr, int n) {
        boolean[] num = new boolean[100];

        for (int i = 0; i < n; i++) {
            // 체크
            if (num[arr[i]]) {
                return 1;
            }
            // 넣기
            num[100 - arr[i]] = false;
        }
        return 0;
    }

    /**
     * n이 제곱수이면 1 반환, 아니면 0 반환
     */
    // O(1)
    static int func3(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt == (int) sqrt) {
            return 1;
        }
        return 0;
    }
    // O(√N)
    static int func3_1(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 가장 큰 2의 거듭제곱수를 반환하는 함수
     */
    // O(logN)
    static int func4(int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; Math.pow(2, i) <= n; i++) {
            max = Math.max((int) Math.pow(2, i), max);
        }
        return max;
    }

    // O(logN)
    static int func4_1(int n) {
        int val = 1;
        while (2 * val <= n) {
            val *= 2;
        }
        return val;
    }

    public static void main(String[] args) {
/*
        System.out.println(func1(16));
        System.out.println(func1(34567));
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 48}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));

        System.out.println(func3(9));
        System.out.println(func3(693953651));
        System.out.println(func3(756580036));
 */
        System.out.println(func4(5));
        System.out.println(func4(97615282));
        System.out.println(func4(1024));
        /**
         * 실수 다룰때 주의사항
         * 1. 실수 저장 / 연산 과정에서 반드시 오차가 생길 수 밖에 없다
         * 2. double에 long 범위 정수 저장시 오차가 섞인 값이 저장될 수 있다.
         * 3. 실수 비교시 == 쓰면 안된다!
         */
        // false
        System.out.println(0.1 + 0.1 + 0.1 == 0.3);
        double a = 0.1 + 0.1 + 0.1;
        double b = 0.3;
        int compare = Double.compare(a, b);
        System.out.println(compare);    // a가 더 크다고 나옴 ( 결과값 : 1 )

        if (Math.abs(a - b) < 1e-12) {
            System.out.println("SAME");
        }
    }
}
