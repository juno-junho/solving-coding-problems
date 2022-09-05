import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 정수 뒤집기 -> 몫, 나머지 이용까지는 good. but 합치는데 있어서 int 변수 사용하기.
class Array6 {
    List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            //arr를 뒤집기
            sb = new StringBuilder();
            while (arr[i] >= 10) {
                sb.append(String.valueOf(arr[i] % 10));
                arr[i] /= 10;
            }
            sb.append(arr[i]);
            if (isPrime(Integer.parseInt(sb.toString()))) list.add(Integer.parseInt(sb.toString()));
        }
        return list;
    }

    List<Integer> solution1(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //arr를 뒤집기
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) list.add(res);
        }
        return list;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Array6 T = new Array6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        T.solution(n, arr).forEach(i -> System.out.print(i + " "));
    }
}
