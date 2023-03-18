package freecourse.week1.problem3;

import java.util.stream.IntStream;

import static freecourse.week1.problem3.ValidNumber.*;

public class Game369 {

    private int clapCount;

    public void playTheGame(int number) {
        validate(number);
        this.clapCount = IntStream.rangeClosed(1, number).map(this::countNumberThreeSixNine).sum();
    }

    private void validate(int number) {
        if (isValidNumber(number))
            throw new IllegalArgumentException("숫자 범위는 1 이상 10,000 이하 입니다.");
    }

    private boolean isValidNumber(int number) {
        return number < MAX_NUMBER.getNumber() || number > MIN_NUMBER.getNumber();
    }

    private int countNumberThreeSixNine(int number) {
        int countedNum = 0;
        while (number > 0) {
            if (isThreeSixNine(number))
                countedNum++;
            number /= 10;
        }
        return countedNum;
    }

    private boolean isThreeSixNine(int number) {
        return (number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9;
    }

    public int getClapCount() {
        return this.clapCount;
    }
}
