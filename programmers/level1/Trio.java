public class Trio {
    /** 삼총사
     * number 배열이 주어질때, 3개를 더해서 0이 되는 경우의 수의 총합을 구해라
     * 헷갈린것 : two pointer algorithms - 리스트에서 연속하는 수까지의 합이 m이 되는 경우일때 사용.
     * 근데 이 문제는 연속하는 수의 합이 0이 아님.
     * */
    public int solution(int[] number) {
        int pointer2;
        int pointer3;
        int result = 0;

        for (int pointer1 = 0; pointer1 < number.length; pointer1++) {
            pointer2 = pointer1 + 1;
            pointer3 = pointer2 + 1;
            while (pointer2 < number.length - 1) {
                while (pointer3 < number.length) {
                    if (number[pointer1] + number[pointer2] + number[pointer3] == 0) {
                        result++;
                    }
                    pointer3++;
                }
                pointer2++;
                pointer3 = pointer2 + 1;
            }
        }

        return result;
    }

    /** 3중 for문을 사용한 풀이
     * 시간복잡도 O(n^3) */
    public int solution2(int[] number) {
        int answer = 0;

        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i]+number[j]+number[k]==0) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Trio trio = new Trio();
        System.out.println(trio.solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(trio.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(trio.solution(new int[]{-1, 1, -1, 1}));

    }

}
