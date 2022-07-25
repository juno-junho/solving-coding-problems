import java.math.BigInteger;

public class NormalSquare {
    // 최대공약수 구하기 -> 유클리드 호제법 이해
    // + 최소공배수 구하기 = a * b / 두수의 최대공약수 (걍 외우는 수 밖에 ..)
    // BigInteger의 gcd 메소드....
    public long solution2(int w, int h) {
        long totalCount = (long) w * (long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return totalCount - diagonalCount;
    }

    static long solution(int w, int h) {
        // w*h에서 색칠된것 뺀다.

        //w와 h의 최대공약수를 구한다. g라 했을때, w/g 와 h/g의 사각형의 검정 부분 개수 * h / h/g 만큼을 w*h에서 빼준다

        // 문제는 최대공약수가 1인 w * h 사각형에서 검정색 부분의 개수를 어떻게 구하냐는 것.

        // 이건 수학이다...
        // 격자점 개수 : w, h 최대공약수 - 1
        // 격자점 존재 -> 가로 + 세로 -1 - 격자점 개수
        // 격자점 존재  -> 가로 + 세로 -1
        int latticePoint = gcd(w, h) -1;
        long colored = w + h -1 -latticePoint;
        long answer = (long)w*(long)h - colored;
        return answer;
    }
    static int gcd(int w, int h){
        // 최대 공약수 구하는 방법 : w, h 작은것 . 1부터 하나씩 올라가며 둘다 나눠 떨어지면 대체
        int result = 1;
        for (int i = 2; i <= Math.min(w, h); i++) {
            if (w % i ==0 && h % i ==0) result = i;
        }
        return result;
    }
    static int gcd1(int w, int h){
       // O(n)
        while (h !=0){
            int r = w % h;
            w = h;
            h = r;
        }
        return w;
    }
    static int gcd2(int w, int h){
        if (w%h == 0) {
            return h;
        }
        return gcd2(h, w % h);
    }

    public static void main(String[] args) {

        System.out.println(solution(8,12));
    }
}