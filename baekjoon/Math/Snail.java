import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        // total length : v
        // day 1 : v -a +b
        // day2 : v + (-a + b) * days
        // day 2 : v -2*a +b <0 면 2출력
        // day 3 : v -3a + 2b <0 이면 3출력
        // 1000000000 -100*n + 99*(n-1) <=0 이면 n 출력 // 1000000000-99 <= n
        // v - a*n + +b*n -b <=0 -> n 출력
        // n(b-a) <= b-v
        // n >= (v-b) / (a-b)
        //5 1 6 ->  -5 / -4

        // 올라가야할 길이 : v  + (-a + b) * days < 0 되는 day 구하면 됨.
        // day> -v /b-a day > x
        // 5 1 6
        // 7/3  -> 2. xx  2

        int result = (v - b) / (a - b);
        if ( (v - b) % (a - b) == 0) System.out.println(result);
        else System.out.println(result + 1);
    }
    // 틀린이유 : Scanner 말고 BufferedReader를 사용하자.
    /*
    import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		int day = (length - down) / (up - down);
		if ((length - down) % (up - down) != 0)
			day++;

		System.out.println(day);
	}
}
     */
}
