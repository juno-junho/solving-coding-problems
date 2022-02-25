package recursion;


public class CountingStar {
    public String output(int number){
        String block1 = "***";
        String block2 = "* *";

        if(number == 3) {
            return block1 + "\n" + block2 + "\n" + block1;

        }
        return output(number / 3);
    }
    public static void main(String[] args) {
        CountingStar countingStar = new CountingStar();
        System.out.println(countingStar.output(3));
    /*
    생각과정
    1. 첫줄에는 number만큼 별찍기
    2. 둘쨋줄에는 하나찍고 하나뛰고 하나찍고 하나찍고 1 0 2 0 2 0.. 1
    3. 셋쨧줄에는 number만큼 찍기
    4. 넷째줄 3 0 3 0 3 0 ..
    5. 다섯쨋줄 : 1 0 1 0 0 0
     */
    }
}
