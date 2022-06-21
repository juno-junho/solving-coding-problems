import java.util.ArrayList;
import java.util.List;
public class Crain {
    // stack 공부하기. 풀이법 따라 공부하기. 풀이법 다시 공부하기.
    //int[] moves = { 1,5,3,5,1,2,1,4}; // int[i][j] 일때, j를 말함. i는 0이 아닌 최소값.
    //일단 해당 값을 찾은 다음 board는 0으로 만들어 준다. 그렇게 계속 찾아 배열 basket에 하나씩 넣어준다.
    // basket 배열에서 다음 값이랑 같으면 없애는 과정 반복. 그 없어진 수를 return
    static int solution(int[][] board, int[] moves) {
        List<Integer> basket = new ArrayList<>();
        for (int move : moves) {
            for (int[] ints : board) {
                if(ints[move-1] != 0) {
                    basket.add(ints[move-1]);
                    ints[move-1] = 0;
                    break;
                }
            }
        }
        System.out.println(basket);
        // basket에서 숫자 없애주고 count 증가시키기.
        int count = 0;
        int remove= 0;
        boolean flag = true;
        while (flag){
            if (basket.size() <= 1) break;
            for (int i = 0; i < basket.size() -1 ; i++) {
                if(basket.get(i).equals(basket.get(i + 1))) {
                    remove = i;
                    flag = true;
                    break;
                }else flag = false;
            }
            if (!flag) continue;
            basket.remove(remove);
            basket.remove(remove);
            count += 2;
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {0,2,4,4,2},
                {0,5,1,3,1},
        };
        int[] moves = { 1}; // int[i][j] 일때, j를 말함. i는 0이 아닌 최소값.
        //일단 해당 값을 찾은 다음 board는 0으로 만들어 준다. 그렇게 계속 찾아 배열 basket에 하나씩 넣어준다.
        // basket 배열에서 다음 값이랑 같으면 없애는 과정 반복. 그 없어진 수를 return
// 4 3 1 1 3 2 4 // 4 3 3 2 4 // 4 2 4 -> 4개 터트려짐
        solution(board,moves);
    }
}
