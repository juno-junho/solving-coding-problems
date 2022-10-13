package engineerkorea;

/**
 * 주어진 문자열이 회문 (palindrome)을 만들 수 있는 문자열의 치환(Permutation)인지를 확인하는 함수를 만드시오
 *
 * 회문(Palindrome) : 앞으로 읽으나 뒤로 읽으나 똑같은 단어나 문장을 말함. (mom, racecar)
 * 치환(Permutation) : 문자열 안에 문자의 순서를 바꾼 것. (mmo, omm)
 * palindrome 확인 방법 : pointer 두개 양끝에 확인한 다음 중간으로 이동하면서 같은지 확인.
 * 하지만 palindrome을 만들 수 있는 문자열인지를 찾아야 함 -> 특징 : 모든 문자열이 짝수개이거나 한 문자만 홀수 개.
 * -> 각 문자의 개수를 세서 문자별로 배열에 저장한 후에 배열 돌면서 홀수개의 문자가 하나 보다 많으면 palindrome 불가능
 */
class StringPalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindromeLessCode("aa bb cc dd"));
        System.out.println(isPermutationOfPalindromeLessCode("aa bb cc dd e"));
        System.out.println(isPermutationOfPalindromeLessCode("aa bb cc dd e fff"));
    }
    private static boolean isPermutationOfPalindrome(String s) {
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (!foundOdd) foundOdd = true;
                else return false;
            }
        }
        return true;
    }

    private static int[] buildCharFrequencyTable(String s) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1]; // 26개의 방을 만들기.
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    private static int getCharNumber(char c) {
        int a =  Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) return val - a;
        return -1;
    }

    // 개수를 세면서 홀수개 문자가 몇개인지를 동시에 세는 것 -> 따로 또 돌지 않아도 된다.
    private static boolean isPermutationOfPalindromeLessCode(String s) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) countOdd++;
                else countOdd--;
            }
        }
        return countOdd <= 1;
    }
    // a ~ z 까지 돌면서 1 << i 로 checker에 저장하는데 기존 홀수개면 해당 스위치 0으로 세팅. 짝수개 있었으면 해당 스위치 1로 세팅
    private static boolean isPermutationOfPalindromeUsingBitOperation(String s) {
        int bitVector = createBitVector(s); // 짝수, 홀수 비트값을 만드는 함수
        return bitVector == 0 || checkExactlyOneBitSet(bitVector); // bitVector ==0 : 모두 짝수이거나 하나만 홀수 있는지 함수


    }
    private static boolean checkExactlyOneBitSet(int bitVector) { // bitVector 안에서 하나만 홀수개인지 정의하는 함수
        // bitVector에서 1을 뺀것과 & 했을때 0이 나와야함.
        return ((bitVector & (bitVector - 1)) == 0);
    }

    private static int createBitVector(String s) {
        int bitVector = 0;
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);    // 여기서 알파벳 배열방 index 반환 or -1
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;
        int mask = index << 1;
        if((bitVector & mask) == 0) { // bitVector에 스위치 꺼져있을때
            bitVector |= mask;
        }else{ // 스위치 켜저 있으면 0으로 꺼야함.
            bitVector &= ~mask;
        }
        return bitVector;
    }
}
