import java.util.Scanner;

public class CheckInput {
    static boolean isNumber(String string){
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (!isNumber(str)) System.out.println("Integer");
        else System.out.println("String");
    }
}
