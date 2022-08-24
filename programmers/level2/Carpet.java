public class Carpet {
    // 근의 공식으로 풀수도 있음.
    public int[] solution2(int brown, int yellow) {
        int a = (brown+4)/2;
        int b = brown + yellow;
        int[] answer = {(int)(a+ Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
    public int[] solution(int brown, int yellow) {

//        int[] answer = new int[2];
        // brown + yellow -> 전체 사각형의 넓이.
        // brown + yellow의 공약수 중 하나.
        // retrun 값의 덧셈 * 2 -4 가 brown 의 수.


        // 2(a + b) - 4 = brown  // (brown + 4)/2 = a + b;
        // a * b = brown + yellow
        //


        int totalSize = brown + yellow;

        for (int i = 1; i <= totalSize; i++) {
            if((double)totalSize / i + i == (brown+4)/2) {
                return new int[]{totalSize / i, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
