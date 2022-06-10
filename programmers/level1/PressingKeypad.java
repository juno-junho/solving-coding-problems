import java.util.*;

public class PressingKeypad {
    public String solution(int[] numbers, String hand) {
        Set<Integer> leftNum = new HashSet<>();
        Set<Integer> rightNum = new HashSet<>();
        Set<Integer> middleNum = new HashSet<>();

        leftNum.add(1); leftNum.add(4); leftNum.add(7);
        rightNum.add(3); rightNum.add(6); rightNum.add(9);
        middleNum.add(2); middleNum.add(5); middleNum.add(8); middleNum.add(0);

        List<String> result = new ArrayList<>();
        // 손가락 위치를 기억할 수 있도록 만들어 줘야함.
        int rlocation;
        int llocation;

        for (int i = 0; i < numbers.length ; i++) {
            if (leftNum.contains(numbers[i])){
                result.add("L");
                llocation = numbers[i];
            }
            if (rightNum.contains(numbers[i])){
                result.add("R");
                rlocation = numbers[i];
            }
            if (middleNum.contains(numbers[i])){
                if (hand.equals("left")){

                }
            }
        }
//        result.lastIndexOf("L")
        return "A";

    }

    public static void main(String[] args) {


    }
}
