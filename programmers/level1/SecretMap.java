import java.util.Arrays;
// 비트연산 정리하기
// string format 정리하기.
// string replace, replaceAll 사용방법 명확히 알기.(char와 정규식 차이)
// string 앞에 문자 붙히기 : stringbuilder.insert(0,"문자") 사용

public class SecretMap {
    static String[] solution(int n, int[] arr1, int[] arr2) {
      // 1. 일단 arr1, arr2 를 2진수로 변환한다.
        // 2. 합친다.
        // 그리고 1인 부분을  #으로 변환해 출력한다.
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            // 비트 연산
            int num1= arr1[i];
            int num2= arr2[i];
            StringBuilder sb = new StringBuilder();
            String replace = Integer.toBinaryString(num1 | num2).replace('1', '#').replace('0', ' ');
            for (int j = 0; j < n -replace.length() ; j++) {
                sb.insert(0," ");
            }
            sb.append(replace);
            answer[i] = sb.toString();
//            s.replace("1", "#");
//            StringBuilder sb1 = new StringBuilder();
//            StringBuilder sb2 = new StringBuilder();
//            String s1 = Integer.toBinaryString(arr1[i]);
//            String s2 = Integer.toBinaryString(arr2[
////            sb.append()
//            for (int j = 0; j < 5-s1.length() ; j++) {
//                sb1.append("*");
//            }
//            sb1.append(s1);
//            for (int j = 0; j < 5-s2.length() ; j++) {
//                sb2.append("*");
//            }
//            sb2.append(s2);
//            char[] chars1 = s1.toCharArray();
//            char[] chars2 = s2.toCharArray();
//            for (int j = 0; j < chars1.length; j++) {
//                if (chars1[i] == '0' &&b chars2[i] == '0')
//            }


        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
//        int num1= 22;
//        int num2= 14;
//        System.out.println(Integer.toBinaryString(num1));
//        System.out.println(Integer.toBinaryString(num2));
//        System.out.println(Integer.toBinaryString(num1 | num2).replace('1', '#').replace('0',' '));
    }



}
