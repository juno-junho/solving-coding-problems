class BitOperation {
    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    // 해당 자리수 0으로 세팅
    static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    static int clearLeftBits(int num, int i) {
     return num & (1 << i) -1;
    }

    public static void main(String[] args) {
        System.out.println(getBit(9, 3));
        System.out.println(getBit(5, 3));
    }
}
