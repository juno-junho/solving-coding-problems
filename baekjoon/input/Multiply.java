import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[] chars = Integer.toString(b).toCharArray();
        System.out.println(Integer.parseInt(String.valueOf(chars[2]))*a);
        System.out.println(Integer.parseInt(String.valueOf(chars[1]))*a);
        System.out.println(Integer.parseInt(String.valueOf(chars[0]))*a);
        System.out.println(a*b);
*/
        //2 String substring 사용
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(Integer.parseInt(b.substring(2))*Integer.parseInt(a));
        System.out.println(Integer.parseInt(b.substring(1,2))*Integer.parseInt(a));
        System.out.println(Integer.parseInt(b.substring(0,1))*Integer.parseInt(a));
        System.out.println(Integer.parseInt(b)*Integer.parseInt(a));

        //3 cleaner
        /*
          String a = sc.nextLine();
        String b = sc.nextLine();

        int t1 = Integer.parseInt(b.substring(2))
        int t10 = Integer.parseInt(b.substring(1,2))
        int t100 = Integer.parseInt(b.substring(0,1))

        int firstNumber = Integer.parseInt(a);

        System.out.println(firstNumber*t1);
        System.out.println(firstNumber*t10);
        System.out.println(firstNumber*t100);
        System.out.println(((firstNumber*t100)*100) + ((firstNumber*t10)*10) + ((firstNumber*t1));

         */


    }
}
