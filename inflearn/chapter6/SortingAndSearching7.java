import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SortingAndSearching7 {
    Coordinate[] solution(Coordinate[] arr, int n) {
        Arrays.sort(arr, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                // 순서 -> 음수값이 return 되게 해야한다.
                if (o1.getX() != o2.getX()) return o1.getX() - o2.getX();
                else return o1.getY() - o2.getY();
            }
        });
        return arr;
     }

    public static void main(String[] args) {
        SortingAndSearching7 T = new SortingAndSearching7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coordinate[] arr = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Coordinate(sc.nextInt(), sc.nextInt());

        }
        for (Coordinate i : T.solution(arr, n)) System.out.println(i.getX() + " " + i.getY());
    }

    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
