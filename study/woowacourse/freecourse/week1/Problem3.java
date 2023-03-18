package freecourse.week1;

import freecourse.week1.problem3.Game369;

public class Problem3 {

    public static int solution(int number) {
        Game369 game369 = new Game369();
        game369.playTheGame(number);
        return game369.getClapCount();
    }

    static boolean isThreeSixNine(int number) {
        return number % 10 == 3 || number % 10 == 6 || number % 10 == 9;
    }

    public static void main(String[] args) {
        System.out.println(Problem3.solution(10000));
        System.out.println(Problem3.solution(33));

    }
}
