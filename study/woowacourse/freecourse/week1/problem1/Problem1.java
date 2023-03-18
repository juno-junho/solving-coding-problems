package freecourse.week1.problem1;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수. 1 ~ 400 페이지의 책
        // 왼쪽 페이지 번호 숫자 각자리 모두 더하거나 곱해 가장 큰수
        // 오른쪽 페이지 번호 숫작 각자리 모두 더하거나 곱해 가장 큰수
        // 그중에 가장 큰수를 본인의 점수로 .
        // 시작면, 마지막 면이 나오도록 책 펼지지 않음.

        // 1. 왼쪽 페이지 번호에서 가장 큰수 구한다.
        // 2. 오른쪽 페이지 번호에서 가장 큰수 구한다.
        // 3. 그 둘을 비교해서 자신의 가장 큰수를 구한다.<
        // 4. 둘 비교한다.

        // player를 가지고 와서 비교하기.
        GameBoard gameBoard = new GameBoard(new ScoreCalculator(), new PageValidator()); // validator는 내부에서 처리한다.
        gameBoard.playtheGame(pobi, crong);
        return gameBoard.getResult();
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        System.out.println(Problem1.solution(pobi, crong));


    }
}