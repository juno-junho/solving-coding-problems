package freecourse.week1;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
//    enum Money{
//        CASH1(50_000), CASH2(10_000), CASH3(5_000), CASH4(1_000),CASH5(500),CASH6(100),CASH7(50),CASH8(10), CASH9(1);
//
//        private int value;
//
//        Money(int value) {
//            this.value = value;
//        }
//    }
    public static List<Integer> solution(int money) {
        List<Integer> account = new ArrayList<>();
        List<Integer> won = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
        int index = 0;
        for (int i = 0; i < won.size(); i++) {
            account.add(money / won.get(index));
            money %= won.get(index++);
        }
        return account;
    }
    public static void main(String[] args) {
        System.out.println(Problem5.solution(10000));
    }
}
