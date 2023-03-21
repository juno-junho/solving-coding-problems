import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private List<Integer> convertStringToList(String X) {
        List<Integer> numList = new ArrayList<>();
        for (char c : X.toCharArray()) {
            numList.add(Character.getNumericValue(c));
        }
        return numList;
    }

    public static void main(String[] args) {

        NumberBestFriend numberBestFriend = new NumberBestFriend();
        String result = numberBestFriend.solution("100", "203045");
        System.out.println(result);
    }
}
