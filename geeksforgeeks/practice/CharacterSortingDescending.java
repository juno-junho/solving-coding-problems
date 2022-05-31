import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CharacterSortingDescending {

    //O(n*logn)
    static void descOrder(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        reverse(chars);
        System.out.println(String.valueOf(chars));
    }

    static void reverse(char[] a){
        char temp;
        for (int i = 0; i < a.length/2; i++) {
            temp = a[i];
            a[i] = a[a.length - 1 -i];
            a[a.length -1 -i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        descOrder(s);


    }
}
