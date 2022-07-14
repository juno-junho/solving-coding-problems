public class PYNum {
    static boolean solution(String s) {
        char[] chars = s.toCharArray();
        int pNum = 0;
        int yNum = 0;
        for (char aChar : chars) {
            if (aChar == 'p' || aChar == 'P') {
                pNum++;
                continue;
            }
            if (aChar == 'y' || aChar == 'Y') yNum++;
        }
        System.out.println(pNum);
        System.out.println(yNum);
        return pNum == yNum;
    }
    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));


    }
}
