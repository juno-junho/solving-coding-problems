import java.util.*;
import java.util.stream.IntStream;

class HashMap3 {
    //Time Limit Exceeded
    int[] solution(int n, int k, int[] a) {
        int[] arr = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                map.put(a[j], map.getOrDefault(a[j], 0) + 1);
            }
            arr[i] = map.size();
            map.clear();
        }
        return arr;
    }
    // two pointers algorithms 이용
    // 나는 rt가 0부터 계속 돌았음.
    int[] solution1(int n, int k, int[] a) {
        int[] arr = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            // 계속 더한다.
            map.put(a[rt], map.getOrDefault(a[rt], 0) + 1);
            // k번 더했으면 size를 저장한다.
            if (rt - lt + 1 == k) {
                arr[index++] = map.size();
                if (map.get(a[lt]) - 1 == 0) map.remove(a[lt]);
                else map.put(a[lt], map.get(a[lt]) - 1);
                lt++;
            }
        }
        return arr;
    }
    //Time Limit Exceeded
    int[] solution2(int n, int k, int[] a) {
        int[] arr = new int[n - k + 1];
        IntStream.range(0, n-k+1).forEach(i -> arr[i] = (int) Arrays.stream(Arrays.copyOfRange(a, i, i + k)).distinct().count());
        return arr;
    }

    // 강사풀이
    List<Integer> solution3(int n, int k, int[] a) {
        // rt의 index는 rt + k - 1부터 시작.
        // value가 0이면 지우는것 명심하기.
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // k - 1 전까지 넣어두고
        for (int i = 0; i < k - 1; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        // rt는 k - 1 부터 시작
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(a[rt], map.getOrDefault(a[rt], 0) + 1);
            answer.add(map.size());
            map.put(a[lt], map.get(lt) - 1);
            if (map.get(a[lt]) == 0) map.remove(a[lt]);
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        HashMap3 T = new HashMap3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        for (int i : T.solution2(n, k, arr)) System.out.print(i + " ");
        T.solution3(n, k, arr).forEach(i -> System.out.print(i + " "));
    }
}
