public class Watermelon {
    public static String solution(int n) {
        //다른 풀이 :
//        return new String(new char[n/2 + 1]).replace("/0","수박").substring(0,n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            if (i % 2 ==0) sb.append("수");
            else sb.append("박");
//            sb.append(i % 2 == 0 ? "수" : "박");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(4));


        char[] chars = new char[5];
        for (char aChar : chars) {
            System.out.println(aChar=='\0');
        }
        // char 배열은 처음 생성되면 default 값이 \u0000 or \0 이다.
        int[] ints = new int[10];
        for (int anInt : ints) {
            System.out.println(anInt== '\u0000');
            // int는 0과 \0모두 된다.
        }

    }
}
