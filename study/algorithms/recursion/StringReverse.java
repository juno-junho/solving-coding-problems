package recursion;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringReverse {
    public String reverseString(String word){
        String[] wordArr = word.split("");
        StringBuilder reversedWord = new StringBuilder();

        for (int i = 0; i < wordArr.length; i++) {
            reversedWord.append(wordArr[wordArr.length - 1 - i]);
        }
        return String.valueOf(reversedWord);
    }

    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        System.out.println(stringReverse.reverseString("yoyo mastery"));

    }
}
