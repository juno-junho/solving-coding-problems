import java.util.Scanner;

public class Shom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // n은 index값이고 666이 들어간 수를 찾아야 한다.
        // 666 1666 2666 3666 4666 5666 6661 6662 6662 6663 6664 6665 6666 6667 6668 6669 7666 8666 9666
        // 10666 11666 12666 13666 14666 15666 16661 16662 16663 16664
        int count = 1;
        int num = 666;
        while (count != n){
            num++;
            if (String.valueOf(num).contains("666")) count++;
        }
        System.out.println(num);

  }
}
