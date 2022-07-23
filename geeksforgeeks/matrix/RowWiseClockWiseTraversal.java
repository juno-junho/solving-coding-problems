import java.time.Duration;
import java.time.Instant;

public class RowWiseClockWiseTraversal {

    static int MAX = 10000;
    static int[][] arr = new int[MAX][MAX];
    static void rowMajor(){
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j <MAX ; j++) {
                arr[i][j]++;
            }
        }
    }
    static void colMajor(){
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                arr[j][i]++;
            }
        }
    }
    static void printRowWise(int[][] mat){
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat[i].length ; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
        //Arrays.stream(mat).forEach(ints -> Arrays.stream(ints).mapToObj(anInt -> anInt + " ").forEach(System.out::print));
    static void printColumnWise(int[][] mat){
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat[i].length ; j++) {
                System.out.print(mat[j][i] + " ");
            }
        }
//        for (int j = 0; j < mat[0].length; j++) {
//            for (int i = 0; i < mat.length ; i++) {
//                System.out.print(mat[i][j] + " ");
//            }
//        }
    }

    public static void main(String[] args) {
//        Instant start = Instant.now();
//        rowMajor();
//        Instant end = Instant.now();
//        System.out.println("Row major access time " + Duration.between(start,end)) ;
//
//        start = Instant.now();
//        colMajor();
//        end = Instant.now();
//        System.out.println("Column major access time " + Duration.between(start,end)) ;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.print("Row-wise: ");
        printRowWise(matrix);
        System.out.println();
        System.out.println("----------------");
        System.out.print("Column-wise: ");
        printColumnWise(matrix);
    }
}
