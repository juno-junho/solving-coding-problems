import java.util.Scanner;

class Recursion1 {
    /**
     * 재귀함수
     * <p>
     * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요
     * <p>
     * 재귀함수 : 자기가 자신을 호출하는 함수
     * 재귀함수 구조는 if else 이다. 그렇게 해야한다.
     *
     * 아래 문제에서 System.out.print(n + " "); 룰 dfs 함수 밑에 넣으면 1 2 3 ... 으로 출력되고
     * System.out.print(n + " ");를 dfs 함수 위에 넣으면 ... 3 2 1  으로 출력된다.
     * 이유 : recursion은 stack frame이라는 것을 사용한다. 그렇기 때문이다. (함수 호출 구조 이해하기)
     *
     */
    void dfs(int n) {
        if (n == 0) return;
        else {
//            System.out.print(n + " "); -> 3 2 1 출력됨.
            dfs(n - 1);
            System.out.print(n + " ");
        }
    }

    //그냥 for문 돌기
    int[] solution(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void main(String[] args) {

        Recursion1 T = new Recursion1();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i : T.solution(n)) System.out.print(i + " ");
        T.dfs(3);

    }
}
