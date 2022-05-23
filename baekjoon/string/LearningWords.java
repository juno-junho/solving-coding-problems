import java.util.*;
public class LearningWords {
    // 다시 풀어볼것
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
        // char[] 배열 사용.
        // 중복 없는 걸 뽑는다. 그걸로 for문 돈다.
        // 하나씩 돌면서 같으면 count ++; 해서 젤 높은것 출력

        String distinctword = "";
        for (int i = 0; i < word.length(); i++) {
            if(word.indexOf(word.charAt(i)) == i) distinctword += word.charAt(i);
        }

        int count = 0;
        int max = 0;
        char maxword = ' ';
        for (char distinct: distinctword.toCharArray()) {
            for (char words:word.toCharArray()) {
                if (distinct == words) count ++;
            }
            if ( count > max) {
                max = count;
                maxword = distinct;
                count = 0;
            }
            if (count != 1 && count == max) maxword = '?';
            count = 0;

        }
//        for (int i = 0; i < words.length ; i++) {
//            for (int j = i+1; j < words.length ; j++) {
//                if (words[i] == words[j]) count ++;
//            }
//            if (count != 0 && count == max){
//                maxword = '?';
//            }
//            if (count > max) {
//                max = count;
//                maxword = words[i];
//                count = 0;
//            }
//            count = 0;
//        }
        System.out.println(String.valueOf(maxword).toUpperCase());
    }
}
