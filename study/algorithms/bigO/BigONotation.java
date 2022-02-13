package bigO;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BigONotation {
    // O(n) --> Linear Time
    public void findNemo(String[] array){
        double t0 = System.currentTimeMillis();
        for (String s : array) {
            if (s.equals("nemo")) {
                System.out.println("Found Nemo!");
                break;
                // Rule 1 : Worst Case.
            }
        }

        double t1 = System.currentTimeMillis();
        System.out.println("Call to find Nemo took " + (t1-t0) +
                " milliseconds");
    }

    // O(1) --> Constant Time
    public void compressBoxes(String[] boxes) {
        System.out.println(boxes[0]);
        System.out.println(boxes[1]);
    }

    // O(a + b) --> Rule 3 : Different terms for input
    // if loops are nested : O(a * b
    public void compressBoxes(String[] boxes, String[] boxes2) {
        for (String box : boxes) {
            System.out.println(box);
        }
        for (String box : boxes2) {
            System.out.println(box);
        }
    }

    public int funChallenge(String[] input){
        int a = 10; // O(1)
        a = 50 + 3; // O(1)

        for (int i = 0; i < input.length; i++) { //O(n)
            anotherFunction(); // O(n)
            boolean stranger = true; // O(n)
            a ++;   // O(n)
        }
        return a; // O(1)
        // CALCULATE : 3 + n + n +n +n = 4n + 3
        // BIG O(4n + 3) --> O(n)
    }

    private void anotherFunction() {
    }

    // log all pairs of array --> O(n^2) - Quadratic Time
    public void logAllPairsOfArray(int[] array){
        for (int i : array) {
            for (int j : array) System.out.println(i + ", " + j);
        }
    }

    // 아래 함수의 time complexity : O(n), space complexity : O(1)
    // int i 변수 하나만 사용하기 때문.
    public void booo(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("booooo!");
        }
    }

    public static void main(String[] args) {
        BigONotation bigONotation = new BigONotation();

        String[] nemo = {"nemo"}; // O(1)
        String[] everyone = {"dory", "bruce", "marlin", "nemo", "gill",
        "bloat", "nigel", "squirt", "darla", "hank"}; // O(10)
        String[] large = new String[1000];
        Arrays.fill(large, "nemo"); // O(1000)
        bigONotation.findNemo(large);
    }
}