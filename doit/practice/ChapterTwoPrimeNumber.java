public class ChapterTwoPrimeNumber {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000 ; i++) {
            int j;
            for (j = 2; j < i ; j++) {
                // 나눠 떨어지면 소수가 아님.
                if (i % j == 0) break;
            }
            if (j == i) System.out.println(i);
        }
    }
}
