public class AddingDigits {
    public int solution(int n) {
        int answer = 0;
        String[] words = String.valueOf(n).split("");
        for (String word: words) {
            answer += Integer.parseInt(word);
        }

        return answer;
    }
}
