public class GCDLCM {
        // 재귀함수 풀이법 참고. (유클리드 호제법)
        //
    static int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];
        answer[0] = gcd(a,b);

        // 최소공배수는 최대공약수를 M * N에서 나눈것.
        answer[1] = (a*b)/answer[0];
        return answer;
    }

     static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p%q);
    }


    static int[] solution(int n, int m) {
        // 최대공약수  -> for문 돌자
        int GCD = 1;
        int LCM = Math.min(n,m);
        for (int i = 1; i <= Math.max(n,m); i++) {
            if (n % i == 0 && m % i == 0){
                GCD = i;
                LCM = n * m / GCD;
            }
        }
        for (int i = 1; i <= Math.max(n,m); i++) {
            if ((Math.min(n,m) * i) % Math.max(n,m) == 0) {
                LCM = (Math.min(n,m) * i);
                break;
            }
        }
        // 최소 공배수 :
        // 작은수의 배수가 큰수에 나눠떨어질때의
        return new int[]{GCD, LCM};
    }
    public static void main(String[] args) {

    }
}
