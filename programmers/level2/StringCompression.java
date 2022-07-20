public class StringCompression {
    // 풀이 확인하기... 힘들다. 이렇게 푸는게 맞는지.. 시간이 너무 오래 걸린다.
    // 문자가 반복되지 않아 한번만 나타난 경우 1을 생략
    static int solution(String s) {
        // 일단 1개씩 자른다 -> 다음 문자와 비교한다 -> 다른것 나올때까지 비교 -> 압축 -> sb에 append
        //  -> 다른 것 나온다 -> 기존 설정 문자를 변환한다 ->  .. 똑같이한다. -> index 벗어나면 sb .length 리턴

        // 2개씩 -> 변환 길이
        // 3개씩 -> 변환길이
        // ... n/2개 변환 까지.
        int n = s.length();
        int min = s.length();
        for (int i = 1; i <= n/2 ; i++) {

            StringBuilder sb = new StringBuilder();
            String cut = s.substring(0,i);
            // 자른것.  0 1 2 3 4 5 6 7 8 9
            //         a a b b a c c c
            int count = 1;
            int index = 1;
            while (index*i < n -i +1){ // index가 n보다는 작아야함.
                if (n - index*i <= i) {
                    if (cut.equals(s.substring(index*i))){
                        count++;
                        index++;
                        continue;
                    }
                }
                if (cut.equals(s.substring(index * i, index*i + i))){
                    count++;
                    index++;
                }
                else {
                    if (count == 1) sb.append(cut);
                    else sb.append(count).append(cut);
                    cut = s.substring(index*i, i+index*i);
                    count = 1;
                    index++;
                }
            }
            if (count == 1) sb.append(cut);
            else sb.append(count).append(cut);
            if (index * i <= n)sb.append(s.substring(index*i));
            System.out.println(i + " : " + sb + " 길이 : " + sb.length());
            min = min > sb.length() ? sb.length() : min;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}
