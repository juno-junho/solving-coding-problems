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
