import java.util.*;

class HashMap5 {
    // set + 정렬 == TreeSet 사용하기. TreeSet은 Collection.sort() 사용할 필요없이 자동으로 sort 해준다!!
    // Tree
    // set 출력방법 잘 알기. for each문, iterator, forEach()메소드
    int solution(int n, int k, Integer[] arr) {
        // arr 중에 3장을 뽑아 적힌 수를 합하려고 할때, k번째로 큰수
        Arrays.sort(arr, Comparator.reverseOrder());
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if (sum == arr[i] + arr[j] + arr[l]) continue;
                    sum = arr[i] + arr[j] + arr[l];
                    count++;
                    System.out.println(count + " : " + (arr[i] + arr[j] + arr[l]));
                    if (count == k) return (arr[i] + arr[j] + arr[l]);
                }
            }
        }
        return -1;
    }
    // 강사풀이
    int solution1(int n, int k, Integer[] arr) {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        // 범위를 n까지라 해도 범위 넘어가면 error 뜨는게 아니라 범위가 false라 set에 add되지 않는다.
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer num : set) {
            cnt++;
            if (cnt == k) return num;
        }
        return -1;
    }
    public static void main(String[] args) {
        HashMap5 T = new HashMap5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, k, arr));
    }
}
