import java.util.Scanner;

public class SugarDelivery {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nKilo = sc.nextInt();

        // n kg이 있을때, 5kg로 나눈 몫. 그리고 나머지를 3으로 나누면 된다 -> 이렇게 생각하면 안됨.
        // 6인경우 3으로 두봉지 밖에 안나오기 때문에.
        // 그럼 어떻게 해야하지
        // 5로 나눠보고 3으로 나눠 보고 안떨어진다 -> 나머지에 5를 더해서 3으로 나눠본다 -> 안떨어진다 -> 계혹 반복한다.
        // 그렇게 하고 끝까지 3으로도 나눠 떨어지지 않는다 -> -1반환한다.
        int leftKilo = nKilo % 5;
        int five = nKilo/5;
        int three = leftKilo/ 3;
        while (true){
            if (leftKilo%3 == 0){
                System.out.println(five + three);
                break;
            } else {
                leftKilo += 5;
                five += -1;
                three = leftKilo/ 3;
                if (five < 0) {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
