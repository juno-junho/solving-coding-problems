import java.util.Arrays;
import java.util.Comparator;

public class StringSortingByLength2 {

    // sorted array 출력
    static void printArraystring(String[] str, int n){
        for (int i = 0; i < n; i++) {
            System.out.println(str[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[ ]arr = {"GeeksforGeeks", "I", "from", "am"};
        int n = arr.length;

        // sorting
        /*
        Comparable과 Comparator는 모두 객체를 비교 하는 것을 구현 할 때 쓰는 인터페이스
        차이점은 비교대상이 다르다는 점.
        Comparable : 자기 자신과 매개변수 객체를 비교 (자기 자신(객체)와 파라미터에 들어오는 객체 비교) lang package에 존재
        Comparator : 두 매개변수 객체를 비교 (자기 자신의 상태가 어떻던 상관없이 파라미터로 들어오는 두 객체 비교) util package에 존재
        주의할 점 : override해서 구현 시, 반드시 객체 비교

        자바에서는 특별한 정의가 되어있지 않는 한 '오름차순'을 기준으로 정렬.
        Arrays.sort(), Collections.sort()모두 오름차순으로 정렬.

        자바에서는 오름차순을 디폴트 기준으로 삼고 있다. 선행 원소가 후행 원소보다 작다는 뜻이다.
        즉, compare 혹은 compareTo를 사용해 객체를 비교할 경우, 음수가 나오면 두 원소의 위치를 바꾸지 않는다.

        두 수를 비교해서
        음수일 경우 : 두 원소의 위치 교환 x
        양수일 경우 : 두 원소의 위치 교환 o

         */
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? -1 : 1;
            }
        });
        // Calling the function to print result
        printArraystring(arr,n);

    }
}
