import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// ** list.remove 쓸때 주의하기!!
// 강사 풀이 확인.
class SortingAndSearching4 {

    //  가장 오랫동안 사용하지 않은 것을 제거한다.
    List<Integer> solution(int s, int n, int[] arr) {
        List<Integer> cache = new ArrayList<>();
        // arr에서 하나씩 추가해서 앞에서 부터 넣는다.
        for (int i = 0; i < n; i++) {
            // 하나씩 list에 넣는데 cache에 존재한다면 list에서 삭제후 다시 넣기.
            // 존재하지 않으면 가득 찼으면(size == s) 맨앞 지우고 집어 넣고 size s가 아니면 그냥 밀어넣기.
            if (cache.contains(arr[i])) {
                cache.remove(Integer.valueOf(arr[i]));
                cache.add(arr[i]);
            } else if (cache.size() == s) {
                cache.remove(Integer.valueOf(cache.get(0)));
                cache.add(arr[i]);
            } else cache.add(arr[i]);
        }
        Collections.reverse(cache);

        return cache;
    }
    // 강사 풀이.
    int[] solution1(int s, int n, int[] arr) {
        // miss 나면 끝에서 돌면서 c[i] = c[i-1]로 복사됨.
        // hit 면 hit 지점부터 index가 돈다.
        int[] cache = new int[s];
        for (int x : arr) {
            // cache에 x가 있는지 확인한다. 있으면 그 index 저장
            int index = s - 1;
            for (int i = 0; i < s; i++) if (x == cache[i]) index = i;
            for (int i = index; i > 0; i--) cache[i] = cache[i - 1];
            cache[0] = x;
        }
        return cache;
    }
    public static void main(String[] args) {
        SortingAndSearching4 T = new SortingAndSearching4();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i : T.solution1(s, n, arr)) System.out.print(i + " ");
//        T.solution(s, n, arr).forEach(i -> System.out.print(i + " "));
    }
}
