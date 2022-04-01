import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        /*
        1/1  1/2  2/1  3/1  2/2  1/3  1/4  2/3  3/2+

        n*(n+1)/2 < x < (n+1)*(n+2)/2
        // 짝수 (n이 홀수 -> n+1이 분모, 분자가 1에서 분모는 1씩 줄어들고 분자는 1씩 커진다.
        // 홀수 (n이 짝수 -> n+1이 분자, 분모가 1에서 분자는 1씩 줄어들고 분모는 1씩 커진다.
         */
        int top = 0;
        int bottom = 0;
        int count = 0;
        int fractionNum = 0;
        while (true){
            if (count*(count+1)/2 < x && (count+1)*(count+2)/2 >x){
                fractionNum = count+1;
                x -= count * (count + 1) / 2;
                break;
            }
            count++;
        }
        System.out.println(count);
       if (fractionNum % 2 == 0){
           top = fractionNum -x;
           bottom = x;
       }else {
           bottom = fractionNum -x;
           top = x;
       }
        System.out.println(top);
        System.out.println(bottom);
    }
}
