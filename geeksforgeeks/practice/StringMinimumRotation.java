import java.util.Scanner;

public class StringMinimumRotation {

    static int findRotations(String str) {
        // rotation 중 처음 str과 같아지면 loop 탈출하고 int값 반환
        StringBuilder sb = new StringBuilder(str);
        sb.append(str);
        //sb size는 2n
        for (int i = 1; i <= str.length() ; i++) {
            if(sb.substring(i,i+(str.length())).equals(str)) {
                System.out.println(sb.substring(i,i+(str.length())));
                return i;
            }
        }
        return str.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
//        System.out.println(findRotations(str));

        // 2번째 방법
        String check = "";
        for (int i = 1; i < str.length() + 1 ; i++) {
            check = str.substring(i,str.length())+  str.substring(0,i);
            if (check.equals(str)) {
                System.out.println(i);
                break;
            }
        }
    }
}
