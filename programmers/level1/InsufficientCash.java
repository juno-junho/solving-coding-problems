public class InsufficientCash {
    public long solution2(int price, int money, int count) {
        return Math.max(price*(count*(count+1)/2) - money ,0);
    }
    public long solution1(int price, int money, int count) {
        long totalCash = 0;
        for (int i = 1; i <= count; i++) {
            totalCash += (long) price * i;
        }
        return totalCash - money < 0 ? 0 : totalCash - money;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
