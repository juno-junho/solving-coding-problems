import java.util.Scanner;

public class ChapterTwo02 {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void reverse(int[] a){
        for (int i = 0; i < a.length / 2 ; i++) {
            for (int i1 : a) {
                System.out.print(i1 + " ");
            }
            System.out.println();
            System.out.println("a[" + i + "]과(와) a[" + (a.length-i-1) + "]를 교환합니다." );
            swap(a , i, a.length -i -1);
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }
    static int sumOf(int[] a){
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = {5, 10, 73, 2, -5, 42, 56};
        reverse(x);
        System.out.println(sumOf(x));
    }
}
