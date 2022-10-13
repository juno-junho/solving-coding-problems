package engineerkorea;

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
        return num & ((1 << i) - 1);
    }

    static int clearRightBits(int num, int i) {
        return num & (-1 << (i + 1));
    }

    // 어떤 값으로 setting 할지 value를 받는다.
    // boolean true면 1, false면 0으로 바꿔주기.
    static int updateBit(int num, int i, boolean val) {
        return (num & ~(1 << i)) | ((val ? 1 : 0) << i);
    }

    public static void main(String[] args) {
        System.out.println(getBit(9, 3));
        System.out.println(getBit(5, 3));
    }
}
