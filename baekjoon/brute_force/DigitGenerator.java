import java.util.Scanner;

public class DigitGenerator {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        // 자기 자신 + 각자리수 합이 n인 수(생성자) 중 가장 작은 생성자 출력
        // 없으면  0 return.
        int nLength = n.length();
        int numN = Integer.parseInt(n);
        int min = 0;

        int startNum = numN - 10*nLength;
        int endNum = numN - nLength;

        if (startNum <= 0) startNum = 1;
        if (endNum == 0) endNum = 1;

        for (int i = endNum; i >= startNum ; i--) {
            // 각 자리수 합
            int sum = 0;
            int num = i;
            // 각 자리수 더하기.
            while (num != 0){
                sum += num % 10;
                num /= 10;
            }

            if ((i + sum) == numN) {
                min = i;
            }
        }
        System.out.println(min);
    }
}
