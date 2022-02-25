package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursion {
//    public void inception(){
//        inception();
//    }

    // O(n)
    public int factorialRecursive(int number) {
        // base case
        if (number <= 1) {
            return 1;
        }
        // recursive case
        return number * factorialRecursive(number - 1);
    }
    // O(n)
    public int factorialIterative(int number){
        int result = 1;
        while (number != 1){
            result *= number;
            number --;
        }
        return result;
    }
    // O(2^n) -> dynamic programming 이용하면 O(n)까지 낮출 수 있다.
    public int fibonacciRecursive(int index){
//        if(index == 0){
//            return  0;
//        }
//        if (index == 1){
//            return 1;
//        }
        if (index < 2) return index;
        return fibonacciRecursive(index-1) + fibonacciRecursive(index-2);
    }

//    public int fibonacciIterative(int index){
//        int result = 2;
//        int result2 = 1;
//        int temp = 0;
//        if (index < 3) return index;
//        if (index == 3) return 2;
//        for (int i = 4; i <= index ; i++) {
//            temp = result;
//            result = result + result2;
//            result2 = temp;
//        }
//        return result;
//    }

    //O(n)
    public int fibonacciIterative(int index){
        List<Integer> arr = new ArrayList<>();
        arr.add(0); // 0
        arr.add(1); // 1
        // [0, 1]
        for (int i = 2; i < index + 1; i++){
            arr.add(arr.get(i-1) + arr.get(i-2));
        }
        return arr.get(index);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.factorialRecursive(0));
        System.out.println(recursion.factorialIterative(2));

        //fibonacci
        System.out.println(recursion.fibonacciRecursive(8));
        System.out.println(recursion.fibonacciIterative(8));

//        recursion.inception();

        Scanner sc = new Scanner(System.in);
        System.out.println(recursion.factorialRecursive(sc.nextInt()));

    }
}
