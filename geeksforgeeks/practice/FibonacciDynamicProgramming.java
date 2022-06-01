import java.util.Arrays;

public class FibonacciDynamicProgramming {

    /*
    다이나믹 프로그래밍(Dynamic Programming)
 : 하나의 문제는 단 한번만 풀도록 하는 알고리즘. 해결한 문제는 계속해서 다시 풀지 않고
그 값을 요구할때는 저장해 놨다가 제시할수 있도록 하는 것.

일반적으로 상당수 분할 정복 기법은 동일한 문제를 다시 푼다는 단점이 있다.
딘순 분할 정복으로 풀게 되면 심각한 비효율 성을 낳는 대표적인 예시가 피보나치 수열이다.

예를들어 재귀적으로 함수를 구하게 되면, 반복적으로 데이터를 계산해야한다.
동일한 데이터를 반복해서 계산해야한다.

dynamic programming은 다음의 가정 하에 사용할 수 있다.
1. 큰 문제를 작은 문제로 나눌 수 있다.
2. 작은문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다. ** 핵심

두 가지 가정을 충족할 때,  dynamic programming을 사용할 수 있다.
이 과정에서 이미 구한 답을 잠시 기록해두는 과정을 memoization 메모이제이션이라고 한다.
이미 저장한 값을 단순히 반복하도록만 하면 된다.

     */
    static final int[] d = new int[100];

    static int fibonacci(int x){
        if (x == 1) return 1;
        if (x == 2 ) return 1;
        if (d[x] != 0) return d[x];
        return d[x] = fibonacci(x-1) + fibonacci(x-2);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(d));
        System.out.println(fibonacci(30));
        System.out.println(Arrays.toString(d));
    }
}
