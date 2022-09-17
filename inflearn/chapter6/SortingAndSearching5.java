import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SortingAndSearching5 {

    // hashmap 쓰면 O(n)이다. 정렬로 쓰면 O(nlogn). 정렬로도 풀 수 있다.

    String solution1(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        // O(n)
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) return "D";    // O(1)
            map.put(arr[i], i);
        }
        return "U";
    }
    String solution(int[] arr, int n) {
        // O(nlogn)
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }
        return "U";
    }

    public static void main(String[] args) {
        SortingAndSearching5 T = new SortingAndSearching5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution1(arr, n));

    }
}
