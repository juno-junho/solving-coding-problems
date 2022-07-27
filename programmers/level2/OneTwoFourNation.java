public class OneTwoFourNation {
    // 진짜 현타온다.......
    // 2시간 가까이해서 푼건데.....
    // 다른 사람 정답은 왜이렇게 간단한걸까...
    public String solution1(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
    static String solution(int n) {
        // 이게 3진법으로 변환 한다음에 앞에서 두번째 자리가 0이면, 앞에껄 줄이고 두번째 자리를 4로 바꾸는것이 필요
        //  그냥 0이 나오면 앞에 자리를 1 줄이고 4로 변환.
        // 0이 나온다 -> 계속 변환 필요
        String answer = "";
        String s = Integer.toString(n, 3);
        if (!s.contains("0")) return s;
        else {
            char[] chars = s.toCharArray();
            // 끝부터 변환. 0이 있으면 앞에 -1 하고 4로 변환. (앞에 4면 2로 내리기. 1이면 0으로 내리고.)
            // 나누기 구현인가...
            int i = 0;
            while (i != chars.length) {
                if (chars[i] == '0') { // 맨앞에서 부터 찾았으면
                    if (i == 0) {
                        i++;
                        continue;

                    }
                    if (chars[i - 1] == '4') { // 앞에글자가 4면 2로 바꿔주기
                        chars[i] = '4';
                        chars[i - 1] = '2';
                        i++;
                    } else if (chars[i - 1] == '2') { // 앞굴자가 2면 1로 바꿔주기
                        chars[i] = '4';
                        chars[i - 1] = '1';
                        i++;
                    } else { // 앞글자가 1이면
                        chars[i] = '4';
                        chars[i - 1] = '0';
                        i--;
                    }
                } else i++;
            }
            int index = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != '0') {
                    index = j;
                    break;
                }
            }
            answer = new String(chars);
            if (answer.startsWith("0")) return answer.substring(index);
            else return answer;
        }
    }

    public static void main(String[] args) {
        // int n인 10진수를
        System.out.println(solution(27));
    }
    
}
