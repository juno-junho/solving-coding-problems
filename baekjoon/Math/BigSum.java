import java.math.BigInteger;
import java.util.Scanner;

public class BigSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String number1 = sc.next();
        String number2 = sc.next();
        BigInteger num1= new BigInteger(number1);
        BigInteger num2= new BigInteger(number2);
        System.out.println(num1.add(num2));

    }
}
