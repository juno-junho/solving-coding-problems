package array;

/**
 * 학습할것 : Character.getNumericValue(ch)에 대한 이해
 *  - 대소문자 모두 똑같은 값 반환
 *  - 비트 연산
 *  sol1 과 내 풀이 일치.

 *  Time Complexity : 모두 O(N)
 *  Space Complexity : O(1)
 */
public class Array4 {

    /**
     * 주어진 문자열이 palindrome의 순열인지 아닌지 확인하는 함수 작성.
     * -> 그냥 하면 안되나?
     * 1. 일단 다 소문자로 바꾼다.
     * 2. 공백 개수만 count. -> 공백 다 지운다. (사실 공백도 개수 셀 필요 없음)
     * 3. odd -> 홀수인것 하나까지 가능
     * even -> 홀수인것 하나도 없어야함.
     *
     */
    private static boolean isPermutationOfPalindrome(String phrase) {

        String convertedPhase = phrase.toLowerCase().replaceAll(" ", "");
        char[] chars = convertedPhase.toCharArray();
        int[] alphabet = new int[26];

        for (char letter : chars) {
            alphabet[letter - 'a']++;
        }

        if (convertedPhase.length() % 2 == 1) {
            boolean oddCount = false;

            for (int letter : alphabet) {
                if (letter % 2 == 1) {
                    if (oddCount) {
                        return false;
                    }
                    oddCount = true;
                }
            }
            return !oddCount;
        } else {
            for (int letter : alphabet) {
                if (letter % 2 == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 주어진 문자열이 palindrome의 순열인지 아닌지 확인하는 함수 작성.
     * -> 그냥 하면 안되나?
     * 1. 일단 다 소문자로 바꾼다.
     * 2. 공백 개수만 count. -> 공백 다 지운다. (사실 공백도 개수 셀 필요 없음)
     * 3. odd -> 홀수인것 하나까지 가능
     * even -> 홀수인것 하나도 없어야함.
     */
    private static boolean isPermutationOfPalindrome2(String phrase) {
        int[] alphabet = new int[26];
        String lowercasePhase = phrase.toLowerCase();
        int length = 0;
        for (int i = 0; i < lowercasePhase.length(); i++) {
            char letter = lowercasePhase.charAt(i);
            if (letter == ' ') {
                continue;
            }
            length++;
            alphabet[letter - 'a']++;
        }
        // length 따라 또.. 위 같은 방식
        return true;
    }

    /**
     * solution :
     * 1. hash table 사용
     */
    private static boolean isPermutationOfPalindrome2_sol1(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1]; // 26개의 방을 만들기.
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            // 공백이면 건너뛰기
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) return val - a;
        /*if ('a' <= c && c <= 'z') return c - 'a';
        return -1;*/
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
        return (bitVector & (bitVector - 1)) == 0;
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
        int mask = 1 << index;
        if((bitVector & mask) == 0) { // bitVector에 스위치 꺼져있을때
            bitVector |= mask;
        }else{ // 스위치 켜저 있으면 0으로 꺼야함.
            bitVector &= ~mask;
        }
        return bitVector;
    }
    public static void main(String[] args) {
        System.out.println(Array4.isPermutationOfPalindrome2_sol1("Tact Coa"));
        System.out.println((int)'C');
        System.out.println((int)'c');
        System.out.println(Character.getNumericValue('C'));
        System.out.println(Character.getNumericValue('c'));

    }
}
