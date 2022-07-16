public class Collatz {
    static int solution(long num) {
        if (num == 1) return 0;
        for (int i = 1; i <= 500 ; i++) {
//            System.out.println(num);
            num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
            if (num == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }
}
