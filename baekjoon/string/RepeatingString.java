import java.util.Scanner;

public class RepeatingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int repeatingNumber = sc.nextInt();
            String[] string = sc.next().split("");
            // string 돌면서 반복횟수만큼 각 자리 출력.
            for (String a : string) {
                System.out.print(new String(new char[repeatingNumber]).replace("\0",a));
            }
            System.out.print(" ");
        }
    }
}
/*
mport java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int r;
        String s;

        for(int i =0;i<t;i++){
            r = in.nextInt();
            s = in.next();

            for(int j =0;j<s.length();j++) {
            	for(int k=0;k<r;k++) {
            		System.out.print(s.charAt(j));
            	}
            }
            System.out.println();
        }

        in.close();

    }
}
 */
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			String[] str = br.readLine().split(" ");

			int R = Integer.parseInt(str[0]);

			for (byte val : str[1].getBytes()) {
				for (int j = 0; j < R; j++) {
					sb.append((char)val);
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}



 
 */
