public class ChapterOneFor2 {
    static int sum(int n){
        return (1 + n) * n / 2;
    }
    static int sumOf(int a, int b){
        // a <= n <= b 의 n 합 구하기
        int max, min;
        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        int sum = 0;
        for (int i = min; i <= max ; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sum(n));
    }
}
