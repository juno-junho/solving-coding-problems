import java.util.Scanner;

public class WhatIsRecursion {
    static String text(int n){

        if (n == 1) return text(1);
        return text(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

    }
}
