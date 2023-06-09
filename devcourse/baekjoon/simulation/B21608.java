package simulation;

import java.io.*;
import java.util.StringTokenizer;

public class B21608 {
    static int[][] desks;
    static int[][] preferences;
    public static void main(String[] args) throws IOException {
        B21608 sharkSchool = new B21608();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        desks = new int[N + 1][N + 1];
        preferences = new int[N + 1][4];
        StringTokenizer st = new StringTokenizer(br.readLine());
    }
}
