public class ChapterOneMax1 {
    static int max(int a, int b, int c, int d){
//        int max = (a >= b) ? (a >= c) ? (a >= d) ? a : d : c : b;
        int max = a;
        int max1 = (a < b) ? max = b : a;

        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;

        return max;

    }
    public static void main(String[] args) {
        System.out.println(max(4,3,2,1));
        System.out.println(max(1,2,3,4));
        System.out.println(max(4,2,3,1));
        System.out.println(max(1,2,4,3));
    }
}
