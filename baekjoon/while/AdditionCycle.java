import java.util.Scanner;

public class AdditionCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = 0;
        int count = 0;
        int tens;
        int units;
        int temp = num;
        if (num == 0){
            count++;
        }
        while (result != num){
            if (temp < 10) {
                tens = 0;
                units = temp;
            } else {
                tens = temp / 10;
                units = temp % 10;
            }
            int sum = tens + units; // 14 8
            int right = sum % 10; // 4 8
            int left = units;
            result = (units * 10) + right; // 8+ 4
            temp = result;
            count++;
        }
        System.out.println(count);

//        do {
//            if (num < 10) {
//                tens = 0;
//                units = num;
//            } else {
//                tens = num / 10;
//                units = num % 10;
//            }
//            int sum = tens + units; // 14 8
//            int right = sum % 10; // 4 8
//            int left = units;
//            result = (units * 10) + right; // 8+ 4
//            count++;
//
//        }
//        while (result != num);
//        System.out.println(count);
    }
}
