
public class DivisorNumAndSum {
    static int solution(int left, int right) {
        // 제곱수가 되면 약수의 개수가 홀수개.
        // left~ right 갯수 다 더한것에서 제곱수 개수*2씩 빼면 된다.
//        int[] power = {1,4,9,16,25,36,49,};
    int sum = 0;
        for (int i = left; i <= right; i++) {
            // 아래 따로 만들지 말고 i % Math.sqrt(i) ==0 으로 판별 할 수도 있음.
            if(isRoot(i)) sum -= i;
            else sum+=i;
        }
        return sum;
    }
    static boolean isRoot(int n){
        int sqrt = (int)Math.sqrt(n);
        return Math.pow(sqrt, 2) == n;
    }

    public static void main(String[] args) {
        System.out.println(solution(24,27));
    }
}
