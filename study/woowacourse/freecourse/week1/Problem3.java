package freecourse.week1;

public class Problem3 {

    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            int targetNumber = i;
            while (targetNumber > 0) {
                if(isThreeSixNine(targetNumber)) count++;
                targetNumber /= 10;
            }
        }
        return count;
    }

    static boolean isThreeSixNine(int number) {
        return number % 10 == 3 || number % 10 == 6 || number % 10 == 9;
    }

    public static void main(String[] args) {
        System.out.println(Problem3.solution(10000));
        System.out.println(Problem3.solution(33));

    }
}
