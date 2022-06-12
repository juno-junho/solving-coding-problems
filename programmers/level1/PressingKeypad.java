import java.util.*;

public class PressingKeypad {
    static String solution(int[] numbers, String hand) {
        Set<Integer> leftNum = new HashSet<>();
        Set<Integer> rightNum = new HashSet<>();
        Set<Integer> middleNum = new HashSet<>();

        leftNum.add(1); leftNum.add(4); leftNum.add(7);
        rightNum.add(3); rightNum.add(6); rightNum.add(9);
        middleNum.add(2); middleNum.add(5); middleNum.add(8); middleNum.add(0);

        List<String> result = new ArrayList<>();
        // 손가락 위치를 기억할 수 있도록 만들어 줘야함.
        int rlocation = -1;
        int llocation = -1;

        for (int number : numbers) {
            if (leftNum.contains(number)) {
                result.add("L");
                llocation = number;
            }
            if (rightNum.contains(number)) {
                result.add("R");
                rlocation = number;
            }
            if (middleNum.contains(number)) {
                // 오른쪽과 왼쪽 distance 비교해서 결과. 같으면 hand 비교
                if (distance(number, llocation) < distance(number, rlocation)) {
                    result.add("L");
                    llocation = number;
                } else if (distance(number, llocation) > distance(number, rlocation)) {
                    result.add("R");
                    rlocation = number;
                } else {
                    if (hand.equals("left")) {
                        result.add("L");
                        llocation = number;
                    } else if (hand.equals("right")) {
                        result.add("R");
                        rlocation = number;
                    } else System.out.println("hand 오류");
                }

            }
        }

        // 현재 오른손 위치와 왼손 위치에서 해당 번호 까지의 거리를 계산하는 것이 필요함.
        // 근데 계산을 어떻게 할 것이냐...
        // 번호 하나하나당 이동거리를 저장한다... 아니면... 뭐지...
        // 번호 하나하나당 이동거리를 저장한다... 아니면... 뭐지...
        return String.join("",result);


    }
    static int distance(int num, int location){
        // 1. number가 2인경우
        int result = 0;
        switch (num){
            case 2:
                if (location == 2) break;
                if (location == 1 || location == 3 || location == 5) result = 1;
                if (location == 4 || location == 6 || location == 8) result = 2;
                if (location == 7 || location == 9 || location == 0) result = 3;
                if (location == -1) result = 4;
                break;
            // 2. number가 5인경우
            case 5:
                if (location == 5) break;
                if (location == 2 || location == 4 || location == 6 || location == 8) result = 1;
                if (location == 1 || location == 3 || location == 7 || location == 9 || location == 0) result = 2;
                if (location == -1) return 3;
                break;
            // 3. number가 8인경우
            case 8:
                if (location == 8) break;
                if (location == 5 || location == 7 || location == 9 || location == 0) result = 1;
                if (location == 2 || location == 4 || location == 6 || location == -1) result = 2;
                if (location == 1 || location == 3) result = 3;
                break;
            // 4. number가 0인경우
            case 0:
                if (location == 0) break;
                if (location == -1 || location == 8) result = 1;
                if (location == 5 || location == 7 || location == 9) result = 2;
                if (location == 2 || location == 4 || location == 6) result = 3;
                if (location == 1 || location == 3) result = 4;
                break;
            default:
                System.out.println("Error");
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers,hand));

    }
}
