import java.util.Scanner;

class Array3 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            switch (arr1[i] - arr2[i]) {
                case 0:
                    answer[i] = "D";
                    break;
                case 1:
                case -2:
                    answer[i] = "A";
                    break;
                case 2:
                case -1:
                    answer[i] = "B";
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array3 T = new Array3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        for (int i = 0; i <n; i++) arr2[i] = sc.nextInt();
        for (String i : T.solution(n, arr1, arr2)) System.out.println(i);
    }
}
