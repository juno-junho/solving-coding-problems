public class FindingPrime {
    // dfs 공부하고 풀어야 해서 일단 포기.

    public int solution(String numbers) {
        // number 쪼개서 숫자별로 정렬 ( 0이 맨 앞에 올 순 없다. )
        // 각 숫자들이 primenumber인지 확인 -> count
        int count  = 0;
        char[] chars = numbers.toCharArray();
        for (int i = 0; i < chars.length; i++) {

        }
        int answer = 0;
        return answer;
    }
    public boolean isPrime(int num){
        if (num < 2) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
