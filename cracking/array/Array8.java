package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array8 {
    /**
     * M X N 행렬의 한 원소가 0인 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘 작성

     * 내 풀이:
     * 1. 일단 matrix 한번 다 돌면서 0인 행과 열을 찾는다.
     * 2. matrix를 update 시킨다.

     * solution :
     * 내 풀이 보다 space complexity를 줄일 수 있는 방법이 있다!
     * 1. 첫 row에 zero가 있는지 확인
     * 2. 첫 column에 zero 있는지 확인
     * ----> 이건 마지막에 0으로 row와 column을 세팅해 주기 위해서.
     * 3. 둘째 row, 둘째 column 부터 0인 부분 찾아서 첫 row, 첫째 column 0으로 세팅
     * ----> 그 줄 0으로 지워주기 위해서
     * 4. 둘째 row, 둘째 column 순회 하면서 matrix[i][0]이 0인 모든 행 i를 0으로 세팅. column도 마찬가지.
     * 5. first row, first column 0으로 세팅
     *  (왜 처음꺼는 제외하고 그렇게 처리를 하느냐? -> 0으로 표시하는데 있어서 원래 0이 있었는지, 0으로 세팅한건지를 모르기 때문에
     *  first col, row 를 이용하는것)
     *
     */
    // TIME: O(MN)
    // SPACE: O(M+N)
    static void setZeros(int[][] matrix) {

        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    coordinates.add(new int[]{i, j});
                }
            }
        }

        for (int[] coordinate : coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];

            for (int i = 0; i < matrix[x].length; i++) {
                matrix[x][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
    // TIME: O(MN)
    // SPACE: O(M+N)
    static void setZeros_sol(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < column.length; i++) {
            if (column[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    /**
     * Time : O(n^2) == O(N)  ( col * row ) -> 관점에 따라 다름. O(NM)
     * Space : O(1) using first row & col of matrix to indicate zeros
     */
    static void setZeros_sol2(int[][] matrix) {
        //using the first row & col of matrix to indicate zeros
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // 첫번째 row가 zero 있는지 확인
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        // 첫번째 column이 zero 있는지 확인
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // 첫번째 행, 렬 말고 나머지 0 check, 맨 앞 row, column 0으로 세팅
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        if (colHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 3, 4},
                {5, 6, 7, 0},
                {1, 2, 3, 4}
        };
        System.out.println(Arrays.deepToString(matrix));

        Array8.setZeros(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
