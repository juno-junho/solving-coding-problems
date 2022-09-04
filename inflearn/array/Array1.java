import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Array1 {
    public List<Integer> solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i <n; i++) {
            if (arr[i] > arr[i-1]) list.add(arr[i]);
        }
        return list;
    }
    public static void main(String[] args){
        Array1 T = new Array1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
        T.solution(n, arr).forEach(i -> System.out.print(i + " "));
    }
}