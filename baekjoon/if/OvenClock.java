import java.util.Scanner;

public class OvenClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // hour와 minute 구하기. b+c값이 60 넘으면 a + 1플러스가 hour, minute는 b+c-60
        // a가 hour인데 24를 넘어가면 0으로 세팅
        int hour = a;
        int minute = b+c;
        int count = minute / 60;
        if (count > 0){
            hour += count;
            minute -= count * 60;
            if (hour / 24 > 0) hour =(hour % 24);
        }
        System.out.println(hour + " " + minute);
    }
}
