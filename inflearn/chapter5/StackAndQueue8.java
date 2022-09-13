//import java.util.*;
//
//class StackAndQueue8 {
//    // 어떻게 하는데??? 그 최댓값 비교를 어떻게 하는데?
//
//    int solution(int n, int m, Integer[] arr) {
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i : arr) queue.offer(i);
//
//        Arrays.sort(arr, Collections.reverseOrder());
//
//        while (!queue.isEmpty()){
//            Integer poll = queue.poll();
//            // 최대값이 아니면 다시 뒤에 넣기
//            if (!(poll == arr[0])) {
//                queue.offer(poll);
//                for (int i = 0; i < arr.length-1; i++) {
//                    arr[arr.length - 1] = arr[0];
//                    arr[i] = arr[i + 1];
//                }
//            }
//            else
//        }
//    }
//
//    public static void main(String[] args) {
//        StackAndQueue8 T = new StackAndQueue8();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        Integer[] arr = new Integer[n];
//        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
//        System.out.println(T.solution(n, m, arr));
//
//    }
//}
