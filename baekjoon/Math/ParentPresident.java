import java.util.Scanner;

public class ParentPresident {
//    public int sum(int k,int n){
//        int sum = 0;
//        for (int i = 1; i <= n ; i++) {
//            sum += i*(i+1)/2;
//        }
//        if (k==2) return sum;
//        return sum(k-1,n);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; i++) {
            // k 층 n 호
            int k = sc.nextInt();
            int n = sc.nextInt();
            int sum = 0;

            if(k==1) System.out.println(n*(n+1)/2);
            if(k==2) {
                for (int j = 1; j <= n; j++) {
                    sum += j*(j+1)/2;
                }
            }
//            if (k=3){
//                for (int l = 1; l <= n  ; l++) {
//                    for (int j = 1; j <= n; j++) {
//                        sum += j*(j+1)/2;
//                    }
//                }
//            }
            //반복문을 n번 돌려야한다.. -> 재귀


            /*
            생각 process
            0 층 1 호 : 1 명
            0 층 2 호 : 2 명
            0 층 3 호 : 3 명
            0 층 4 호 : 4 명
            0 층 5 호 : 5 명
            1 층 1 호 : 1 명
            1 층 2 호 : 1 + 2
            1 층 3 호 : 1 + 2 + 3
            2 층 1 호 : 1 (1층 1호)
            2 층 2 호 : 1 + 1+ 2 (1층 1,2호합)
            2 층 3 호 : 1 + 1+2 + 1+2+3(1층 1,2,3호합)
            3 층 1 호 : 1 (1층 1호)
            3 층 2 호 : 1 + 1 + 1+2 (1층 1호 + 2층 2호 = 1층 1호 + 1층 1호 2호 합 = 1층 1호 *2 + 1층 2호합)
            3 층 3 호 : 1 + 1+ 1+2 + 1 + 1+2 + 1+2+3(2층 1, 2, 3호 합 = 1+ 1층 1,2호합 + 1층 1,2,3호합 = 1층 1호*3 + 1층 2호 *2 + 1층 3호)
            4층  1 호
            4 층 2 호 : 1층 1호 *3 + 1층 2호
            4 층 3 호 : 1층 1호 *5 + 1층 2호*3 + 1층 3호*1
             1층 (k=1) n 호일 경우 n(n+1)/2
             2층 (k=2) n 호일 경우 1층 1호 ~ 1층 n호 까지 합
             3층       n 호일 경우 2층 1호 ~ 2층 n호 까지 합
            sigma를 표현할수 있을까
            k 호 일 경우 k-1 호의 1호 ~



        1  4
          1  3  6  10  15
            1  2  3  4  5  6  7  8


             */


        }
    }
}
