package engineerkorea;

/**
 * matrix에서 0을 발견하면, 해당 행과 열을 모두 0 으로 세팅하는 알고리즘 구현
 *
 * 1. 0들을 찾는다 -> 바로 바꾸는 것이 아니라 저장해놓기
 * 2. rows, colums 배열 만들어서 0으로 삭제해야할 곳 저장해서 한번에 삭제
 *
 * -> but 저장공간을 추가로 사용하지 않고 구현할 수 없을까? : 처음만난 0의 행과 열은 어차피 0이 될것이기 때문에
 * 다음 0을 만났을때 0으로 세팅해줘야 하는 행과 열을 처음 0의 행과 열에 세팅한다.
 * 그리고 row와 col에 0으로 되어있는 곳을 전부 0으로 세팅하는데, row를 보고 0으로 바꿀때 정보가 들어있는 col을 제외해야한다 (0으로 세팅시 정보가 사라지므로)
 * 그리고 난 다음 col에 따라 0으로 바꾸고, 마지막에 정보가 들어있던 col또한 0으로 모두 바꿔 준다.
 *
 * 정리하면
 * 1. find 0
 * 2. store the locations
 * 3. set rows & cols to 0 except first col of 0
 * 4. set info col to 0
  */
class MatrixChanging {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
        };
        printImage(matrix);
        setZeroToAllZero(matrix);
        printImage(matrix);
    }

    private static void setZeroToAllZero(int[][] matrix) {
        // 0이 들어가 있는 위치 저장할 행과 열의 방번호
        int fc = -1;
        int fr = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    if (fc == -1) { // 처음 찾은 0 이면
                        fc = col;
                        fr = row;
                    }
                    matrix[fr][col] = 0;
                    matrix[row][fc] = 0;
                }
            }
        }
        if (fc == -1) return; // 0 하나도 못찾았을때.
        // 열을 돌면서 0으로 세팅
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[fr][col] == 0 && col != fc) {    // 정보 들어가 있는 열은 제외
                setColsToZero(col, matrix);
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][fc] == 0) {
                setRowsToZero(row, matrix);
            }
        }
        // 마지막 정보가 들어가 있는 열 0으로 만들기
        setColsToZero(fc, matrix);
    }

    private static void setRowsToZero(int row, int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }

    private static void setColsToZero(int col, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    private static void printImage(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
