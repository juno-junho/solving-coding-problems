import java.util.Scanner;

public class ParentPresident {
    // 풀이 1. 내풀이
    // 풀이 2. 인터넷풀이 (2차원 배열 이용)
    static void peopleNum(int[] n){
        for (int i = 1; i < n.length ; i++) {
            n[i] = n[i-1] + n[i];
        }
    }
    static int sum(int n){
        int sum = 0;
        for (int i = 1; i < n+1 ; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        for (int i = 0; i < testNum; i++) {
            // k 층 n 호
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] kfloor = new int[n];
            // 1층 초기화
            for (int j = 0; j < n ; j++) {
                kfloor[j] = sum(j+1);
            }
            //k층
            for (int j = 0; j < k-1; j++) {
                peopleNum(kfloor);
//                for (int integer:kfloor) {
//                    System.out.print(integer + " | ");
//                }
            }
            System.out.println(kfloor[n-1]);
        }
    }
}
