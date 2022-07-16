public class SquareRoot {
    //(sqrt % 1) == 0 로 정수인지 유리수인지 판별.. -> 정수부분 / 소수부분
    // Math.pow((int)Math.sqrt(n) , 2) == n 으로 판별도 가능.
    static long solution(long n) {
        // n이 제곱근 or 제곱근 아니다  판별
        double sqrt = Math.sqrt(n);
        //(sqrt % 1) == 0 로 정수인지 유리수인지 판별.. -> 정수부분 / 소수부분

        return sqrt / (int) sqrt == 1 ? (long) Math.pow(sqrt + 1, 2) : -1;
    }
    static long solution2(long n) {
        if (n==1) return 4;
        for (long i = 2; i < n ; i++) {
            if (n / i == i && n % i == 0) return (i+1)*(i+1);
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(Math.sqrt(121) / (int)Math.sqrt(121));
        System.out.println(Math.sqrt(3) / (int)Math.sqrt(3));
        System.out.println(Math.sqrt(121) % 1);
        System.out.println(Math.sqrt(3)  % 1);
    }
}
