public class MatrixAddition {
    // 2차원 배열에서 arr.length 하면 요소의 개수가 아니라 row의 개수 나옴.
    // column의 개수는 arr[0].length로 접근 해야함/
    static int[][] solution(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) System.out.println("error");
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length ; i++) {
            for (int j = 0; j <arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] answer = new int[3][4];
        System.out.println(answer.length);
        System.out.println(answer[0].length);
    }
}
