import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiplication {
    public static long C;

    public static long multiply(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long temp = multiply(a, b / 2, c);
        if (b % 2 == 1) {
            return ((temp * temp % c) * a) % c;
        }
        return (temp * temp) % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(multiply(A, B, C));
    }
}
