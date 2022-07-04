public class ChapterOneStar {
    static void triangleLB(int n){
    /*
    *
    **
    ***
    *****
     */
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleLU(int n){
    // 왼쪽 위가 직각
        for (int i = n; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRU(int n) {
        /*
        *****
         ****
          ***
           **
            *
         */
        for (int i = n; i > 0 ; i--) {
            for (int j = 0; j < n- i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRB(int n) {
        /*
             *
            **
           ***
         */
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < n -i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void spira(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < n- i ; j++) {
                System.out.print(" ");
            }
            for (int j =0; j <2*i-1  ; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n- i ; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void npira(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < n- i ; j++) {
                System.out.print(" ");
            }
            for (int j =0; j <2*i-1  ; j++) {
                System.out.print(i);
            }
            for (int j = 0; j < n- i ; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        npira(5);
    }
}
