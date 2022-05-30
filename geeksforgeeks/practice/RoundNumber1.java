import java.util.Scanner;

public class RoundNumber1 {
    // Integer나 Long의 범위가 벗어 났을 때 String으로 받아서 반올림 하는 방법. (1의자리 반올림)
    
    static String round(String s, int n) {
        char[] chars = s.toCharArray();
        // 일의 자리가 0일 경우 그대로 반환
        if (chars[n-1] == '0') return new String(chars);
        // 일의자리가 1,2,3,4일경우 내리고, 5,6,7,8,9의 경우 올리기
        else if (chars[n-1] == '1' | chars[n-1] == '2' | chars[n-1] == '3' | chars[n-1] == '4'){
            chars[n-1] = '0';
            return new String(chars);
        }
        // 나머지는 올림하는데, 10의 자리가 9일 경우 올려야함.
        // 9일경우를 check 해줘야 함.
        // 9가 아니면 그냥 10의 자리만 1올리면 됨.
        chars[n-1] = '0';
        // 10의자리가 9가 아닐때 1더해주고 끝
        if (chars[n-2] != '9') {
            chars[n-2] += 1;
            return new String(chars);
        }

        // 10의 자리가 9일 때
        // 99일경우, 90
        for (int i = n-2; i >= 0 ; i--) {
            if (chars[i] == '9'){
                chars[i] = '0';
                if (i == 0) {
                    chars[0] = '1';
                    String newChar = new String(chars) + "0";
                    System.out.println(newChar);
                    chars = newChar.toCharArray();
//                    chars[n] = '0';
                }
            }else {
                chars[i] += 1;
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String num = sc.nextLine();


        System.out.println("Output : " + round(num,num.length()));

    }
}
