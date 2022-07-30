import java.util.*;

public class MatrixRotating {
    static int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int num = 1;
        // matrix 숫자로 채우기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num;
                num ++;
            }
        }
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            // min 계산
            answer[i] = minimun(matrix,x1,y1,x2,y2);
            System.out.println(Arrays.toString(answer));
            // 회전
            System.out.println(Arrays.deepToString(matrix));
            matrix = rotate(matrix,x1,y1,x2,y2);
            System.out.println(Arrays.deepToString(matrix));
        }
        return answer;
    }

    static int minimun(int[][] matrix,int x1, int y1, int x2, int y2 ){
        // 최솟값 구해주는 메소드...
        int xlength = x2 - x1;
        int yLength = y2 - y1;
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < xlength; i++) {
            x1++;
            arr.add(matrix[x1-1][y1-1]);
        }
        for (int i = 0; i < yLength; i++) {
            y1++;
            arr.add(matrix[x1-1][y1-1]);
        }
        for (int i = 0; i < xlength; i++) {
            x1--;
            arr.add(matrix[x1-1][y1-1]);
        }
        for (int i = 0; i < yLength; i++) {
            y1--;
            arr.add(matrix[x1-1][y1-1]);
        }
        return Collections.min(arr);
    }

    static int[][] rotate(int[][] matrix, int x1, int y1, int x2, int y2){
        // 회전시키는 메소드...
        int xlength = x2 - x1;
        int yLength = y2 - y1;
        int temp1 = matrix[x1 - 1][y1 - 1];
        int temp2;
        for (int i = 0; i < xlength; i++) {
            temp2 =  matrix[x1][y1 - 1];
            matrix[++x1-1][y1-1] =  temp1;
            temp1 = temp2;
        }
        System.out.println(Arrays.deepToString(matrix)
        );
        for (int i = 0; i < yLength; i++) {
            temp2 =  matrix[x1][y1 - 1];
            matrix[x1-1][++y1-1] =  temp1;
            temp1 = temp2;

        }
        for (int i = 0; i < xlength; i++) {
            temp2 =  matrix[x1][y1 - 1];
            matrix[--x1-1][y1-1] =  temp1;
            temp1 = temp2;

        }
        for (int i = 0; i < yLength; i++) {
            temp2 =  matrix[x1][y1 - 1];
            matrix[x1-1][--y1-1] =  temp1;
            temp1 = temp2;
        }
        return matrix;
    }

    public static void main(String[] args) {
        solution(6,6,new int[][]{
            {2,2,5,4},
            {3,3,6,6},
            {5,1,6,3}
        });

    }
}
