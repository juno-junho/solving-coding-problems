public class HarshadNumber {
    static boolean solution(int x) {
        int num = x;
        //  x의 자리수 합
        int sum = 0;
        while (x != 0){
            sum += x % 10;
            x /= 10;
        }
        return num % sum == 0;
    }
    public static void main(String[] args) {
//        System.out.println(solution(10));
        System.out.println(solution(13));

    }
}
