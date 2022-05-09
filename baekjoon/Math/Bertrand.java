import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bertrand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0이 나올때 까지 계속 값 받기.
        while (true){
            int n = sc.nextInt();
            int sum = 0;
            if (n == 0) break;

            List<Boolean> numList = new ArrayList<>(2*n + 1);
            numList.add(false);
            numList.add(false);

            for (int i = 2; i <= 2*n ; i++) {
                numList.add(i,true);
            }

            for (int i = 2; i*i <= 2*n ; i++) {
                if (numList.get(i)){
                    for (int j = i*i; j <= 2*n ; j+=i) {
                        numList.set(j, false);
                    }
                }
            }

            for (int i = n+1; i <= 2*n; i++) {
                if (numList.get(i)) sum ++;
            }

            System.out.println(sum);
        }
    }

}
