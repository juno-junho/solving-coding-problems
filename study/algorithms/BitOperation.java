class BitOperation {
    static boolean getBit(int num, int i) {
        return (num & (i << i)) != 0;
    }

    public static void main(String[] args) {
        System.out.println(getBit(9, 3));
        System.out.println(getBit(5, 3));
    }
}
