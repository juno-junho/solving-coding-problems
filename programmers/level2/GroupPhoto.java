import java.util.Arrays;

public class GroupPhoto {
    // 고민한 흔적.
    // GroupPhoto1이 정답.
    // 자바의 순열에 대해서 공부하기. 백트래킹.
    // https://bcp0109.tistory.com/14
    // https://118k.tistory.com/267
    static final String[] kakaoFriends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int solution(int n, String[] data) {
        // {A, C, F, J, M, N, R, T}
        // data의 길이는 n이라는 말.
        // 8! 이 최대의 수. 재귀를 써야하나??
        // 일단 전체 경우의 수 에서 조건하나하나마다 삭제하여 값을 세팅하는게 맞다고 본다.

//        List<String> kakaoFriends = new ArrayList<>();
//        kakaoFriends.add("A"); kakaoFriends.add("C"); kakaoFriends.add("F"); kakaoFriends.add("J");
//        kakaoFriends.add("M"); kakaoFriends.add("N"); kakaoFriends.add("R"); kakaoFriends.add("T");

//        HashMap<String, Integer> orderMap = new HashMap<>();
//        orderMap.put("A",0); orderMap.put("C",1); orderMap.put("F",2); orderMap.put("J",3);
//        orderMap.put("M",4); orderMap.put("N",5); orderMap.put("R",6);
//
//        Arrays.sort(kakaoFriends, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return orderMap.get(o1) - orderMap.get(o2);
//            }
//        });

        String[] kakaoFriends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        int[] indexArr = {0,1,2,3,4,5,6,7};
//        perm(indexArr,);
        StringBuilder sb = new StringBuilder();
        for (int i : indexArr) {
            sb.append(kakaoFriends[i]);
        }
        String kakao = new String(sb);

        int answer = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) { // 조건 수 만큼 돌기.
            int index1 = kakao.indexOf(data[i].charAt(0));// 첫째글자의 index
            int index2 = kakao.indexOf(data[i].charAt(2));// 둘째 글자의 index
            switch (data[i].charAt(3)) {
                case '=':
                    if (Math.abs(index1 - index2) != Character.getNumericValue(data[i].charAt(4))) flag = false;
                    break;
                case '>':
                    if (Math.abs(index1 - index2) <= Character.getNumericValue(data[i].charAt(4))) flag = false;
                    break;
                case '<':
                    if (Math.abs(index1 - index2) >= Character.getNumericValue(data[i].charAt(4))) flag = false;
                    break;
            }
            if (!flag) break;
        }
        if (flag) answer++;

        // 조건을 통과하면 count ++
        // 그리고 배열의 순서를 바꿔 줘야함.


        return answer;
    }
    static int answer = 0;
     static void perm(int[] arr, int depth,int n, String[] data) {
        if (depth == arr.length) {
            System.out.println(Arrays.toString(arr));
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(kakaoFriends[i]);
            }
            String kakao = new String(sb);
            boolean flag = true;
            for (int i = 0; i < n; i++) { // 조건 수 만큼 돌기.
                int index1 = kakao.indexOf(data[i].charAt(0));// 첫째글자의 index
                int index2 = kakao.indexOf(data[i].charAt(2));// 둘째 글자의 index
                switch (data[i].charAt(3)) {
                    case '=':
                        if (Math.abs(index1 - index2) != Character.getNumericValue(data[i].charAt(4))) flag = false;
                        break;
                    case '>':
                        if (Math.abs(index1 - index2) <= Character.getNumericValue(data[i].charAt(4))) flag = false;
                        break;
                    case '<':
                        if (Math.abs(index1 - index2) >= Character.getNumericValue(data[i].charAt(4))) flag = false;
                        break;
                }
                if (!flag) break;
            }
            if (flag) answer++;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            perm(arr, depth + 1,n,data);
            swap(arr, depth, i);
        }
    }
     static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};

    }

}
