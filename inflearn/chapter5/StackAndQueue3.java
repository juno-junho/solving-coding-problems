import java.util.Scanner;
import java.util.Stack;

class StackAndQueue3 {
    // 강사풀이와 내 풀이가 일치함.
    int solution(int n, int m, int[][] arr1, int[] arr2) {
        int answer = 0;
        // stack에 arr2에 해당하는 숫자(인형)을 담고, 이전것과 같으면 pop 시키고 answer에 더해주기.
        Stack<Integer> stack = new Stack<>();
        // m만큼. 여기서 8번도는데
        for (int i = 0; i < m; i++) {
            // arr2[i] -1의
            for (int j = 0; j < n; j++) {
                int targetNum = arr1[j][arr2[i] - 1];
                if(targetNum != 0) {
                    // stack에 넣기. stack에 있으면 pop시켜 주고 answer에 값 추가.
                    if (!stack.isEmpty() && stack.peek() == targetNum) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.push(targetNum);
                    System.out.println("targetNum = " + targetNum);
                    // 꺼낸 것 0으로 arr1배열 만들어 주기.
                    arr1[j][arr2[i] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    int solution1(int n, int m, int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i = 0; i < n; i++) {
                if(board[i][pos - 1] != 0) {
                    int targetNum = board[i][pos - 1];
                    board[i][pos - 1] = 0;;
                    // stack에 넣기. stack에 있으면 pop시켜 주고 answer에 값 추가.
                    if (!stack.isEmpty() && stack.peek() == targetNum) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.push(targetNum);
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        StackAndQueue3 T = new StackAndQueue3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr1 = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) arr2[i] = sc.nextInt();
        System.out.println(T.solution(n, m, arr1, arr2));
    }
}
