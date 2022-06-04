import java.util.Arrays;

public class StringSortingMinimumCost {
    // Input  : arr[] = {“aa”, “ba”, “ac”},
    //          reverseCost[] = {1, 3, 1}
    // 위 array와 각 index의 reverse cost가 달리 적용되어, reverseCost array로 주어질 경우,
    // array를 알파벳순서대로 각 단어들을 reverse해서 정렬. 그 중 가장 값이 cost가 적게 드는 경우를 출력
    // array의 단어들은 자리바꿈 불가능, reverse만 가능. reverse해도 알파벳순 정렬이 안될 경우 not possible 출력
    //Output : Minimum cost of sorting = 1

    // arr[]를 sorting하는데 필요한 minimum cost를 return. using reverse operation.
    // sort 하는것이 불가능하면 -1 return
    static int minCost(String[] arr, int[] cost, int N) {
        // dp[i][j]는 첫 i string을 sort하게 만들기 위한 minimum cost를 의미함.
        // dp[i][j]는 dp[i-1][1]과 dp[i-1][0]를 사용해 계산함.

        // j == 1은 i번째 string이 reversed 되었다는 의미
        // j == 0은 i번째 string이 reversed 되지 않았다는 의미
        int[][] dp = new int[N][2]; // 세로 n(arr 단어 개수) , 가로 2 의 table
        // dp array first string을 초기화. cost를 저장함.
        dp[0][0] = 0;
        dp[0][1] = cost[0];

        // reversed string의 array.
        // 단어 개수만큼의 string 배열을 만든 다음, (revStr)
        String[] revStr = new String[N];
        System.out.println("revStr =  " + Arrays.toString(revStr));
        for (int i = 0; i < N; i++) {
            revStr[i] = arr[i]; // 해주는 이유가 아래 revStr[i]를 쓰기 때문에 안해주면 NPE 발생.
            System.out.println(revStr[i]);
            revStr[i] = reverse( arr[i], 0, revStr[i].length() -1);
            System.out.println(revStr[i]);
        }
        System.out.println("revStr =  " + Arrays.toString(revStr));
        System.out.println("arr = " + Arrays.toString(arr));

        String curStr = "";
        int curCost;

        // 모든 string들 looping
        for (int i = 1; i < N; i++) { // arrqy 단어 수 만큼 looping
            // 2번 looping. 한번은 string을 위해서, 한번은 reversed string을 위해서
            for (int j = 0; j < 2; j++) { // j수 만큼 2번 looping
                dp[i][j] = Integer.MAX_VALUE;
                // j에 따라서 최신 string과 최신 cost를 가져오기. j == 0 이면 arr와 cost 0, j == 1이면 reverse된것과 cost를 담음.
                curStr = (j == 0) ? arr[i] : revStr[i];
                curCost = (j == 0) ? 0 : cost[i];

                // dp 값을 최신 string이 사전순서상으로 더 크다면(compareTo 메소드 사용) 업데이트
                if (curStr.compareTo(arr[i-1]) >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][0] + curCost);
                if (curStr.compareTo(revStr[i-1]) >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][1] + curCost);
            }
        }

        // 마지막 인덱스의 두 엔트리로부터 최소값 가져오기
        int res = Math.min(dp[N-1][0], dp[N-1][1]);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    static String reverse(String s, int start, int end){
        char temp;
        char[] str = s.toCharArray();
        // start
        while (start < end){
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        String[] arr = {"aa", "ba", "ac"};
        int[] cost = {1, 7, 8};
        int N = arr.length; // 단어 개수

        int res = minCost(arr, cost, N);
        if (res == -1) System.out.println("Sorting is not possible\n");
        else System.out.println("Minimum cost to sort strings is " + res);

    }
}
