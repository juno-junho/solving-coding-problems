import java.util.Scanner;

public class NumberOfWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if (word.equals(" ")) System.out.println(0);
        else {
            String[] letter = word.trim().split(" ");
            System.out.println(letter.length);
        }
    }
}
