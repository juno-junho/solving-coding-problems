public class ChapterOneFor {
    static String forExercise(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            if ( i == n ) {
                result.append(i).append(" = ");
                break;
            }
            result.append(i).append(" + ");
        }
        result.append(sum);
        return result.toString();

//        for (int i = 1; i <= n; i++) {
//            if(i < n)
//                System.out.print(i + " + ");
//            else
//                System.out.print(i);
//            sum += i; // sum에 i를 더함
//        }
//        System.out.println(" = " + sum);
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(forExercise(n));
    }
}
