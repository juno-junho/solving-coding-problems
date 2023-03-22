import java.util.*;

public class NumberBestFriend {
    // 숫자 짝꿍
    public String solution(String X, String Y) {
        List<Integer> xNumList = convertStringToList(X);
        List<Integer> yNumList = convertStringToList(Y);
        List<Integer> intersection = new ArrayList<>();
        int minLength = Math.min(xNumList.size(), yNumList.size());

        if (minLength == xNumList.size()) { // x길이가 더 짧을때. y가 더 길때.
            for (int i = 0; i < minLength; i++) {
                Integer num = xNumList.get(i);
                if (yNumList.contains(num)) {
                    intersection.add(num);
                    yNumList.remove(num);
                }
            }


        } else {
            for (int i = 0; i < minLength; i++) {
                Integer num = yNumList.get(i);
                if (xNumList.contains(num)) {
                    intersection.add(num);
                    xNumList.remove(num);
                }
            }
        }

        intersection.sort(Collections.reverseOrder());

        if (intersection.isEmpty()) {
            return "-1";
        }
        if (intersection.get(0) == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : intersection) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public String solution2(String X, String Y) {

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (char c : X.toCharArray()) {
            int number = Character.getNumericValue(c);
            xMap.put(number, xMap.getOrDefault(number, 0) + 1);
        }

        for (char c : Y.toCharArray()) {
            int number = Character.getNumericValue(c);
            // number개수가 0이면 넘어가기
            // 존재한다면 (0이 아니라면) 넣기
            yMap.put(number, yMap.getOrDefault(number, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (xMap.containsKey(i) && yMap.containsKey(i)) {
                int min = Math.min(xMap.get(i), yMap.get(i));
                String value = String.valueOf(i).repeat(min);
                sb.append(value);
            }
        }
        if (sb.toString().length() == 0) {
            return "-1";
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();

    }


    private List<Integer> convertStringToList(String X) {
        List<Integer> numList = new ArrayList<>();
        for (char c : X.toCharArray()) {
            numList.add(Character.getNumericValue(c));
        }
        return numList;
    }

    public static void main(String[] args) {

        NumberBestFriend numberBestFriend = new NumberBestFriend();
        String result = numberBestFriend.solution2("12321", "42531");
        System.out.println(result);
    }
}
