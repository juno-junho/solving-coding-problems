import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        // minute이 45보다 크면 hour는 그대로 출력, minute는 45 빼서 출력
        if (minute >= 45) System.out.println(hour + " " + (minute-45));
        // minute이 45보다 작으면 hour에서 1빼서 출력, minute + 15출력
        // hour == 0 -> hour = 24로.
        if (hour == 0) hour = 24;
        if (minute < 45) System.out.println((hour-1) + " " + (minute+15));

    }
}
