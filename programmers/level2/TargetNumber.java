public class TargetNumber {
    static int solution(int[] numbers, int target) {
        //  접근 방법 : numbers 하나 하나 돌면서 target 될때까지 + - 해본다.
        // numbers가 n개 있을 때, + -로 O(2*n) 만큼 돌기. xx O(2^n)

        int sum = 0;
//        int[] plusMinus = {1, -1};
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < 2 ; j++) {
//                sum += numbers[i] * plusMinus[j];
//            }
//
//        }
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] * (-1);
//        }
        return sum;
    }
//    static int recursion(int [] numbers, int target){
//
//        return a()
//    }
    public static void main(String[] args) {


    }
}
