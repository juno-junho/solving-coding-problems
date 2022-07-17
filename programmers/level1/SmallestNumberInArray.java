import java.util.Arrays;
import java.util.stream.IntStream;

public class SmallestNumberInArray {
    public int[] solution3(int[] arr) {

        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[arr.length-1];
        int minIndex=0;
         // 최솟값 찾기
        for(int i=0;i<arr.length;i++){
            if(arr[minIndex]>arr[i]){
                minIndex = i;
            }
        }
        // 최솟값 index 없애고 한칸씩 당기기
        for(int i=minIndex+1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        // arr.length - 1 배열에 집어넣기
        for(int i=0;i<answer.length;i++){
            answer[i] = arr[i];
        }
        return answer;
    }
    public int[] solution2(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        // stream으로 최솟값 찾아서 filter로 최솟값 일치하는 것 빼기.
        int min = IntStream.of(arr).min().getAsInt();
        return IntStream.of(arr).filter(i -> i!=min).toArray();
    }

    static int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        // 작은 수 찾기 -> sort해서 맨 앞에꺼 찾음. 그리고 새로운 배열에 하나씩 넣어줌.
        int[] ints = Arrays.copyOf(arr,arr.length);
        Arrays.sort(ints);
        int minNum = ints[0];

        int[] newArr = new int[arr.length-1];
        int index =0;

        for (int i : arr) {
            if (i == minNum) continue;
            newArr[index] = i;
            index++;
        }
        return newArr;
//
//        Integer[] toArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//
//        int[] ints = arr;
//        Arrays.sort(ints);
//        int minNum = ints[0];
//        List<Integer> list = Arrays.asList(toArray);
//        list.remove(Integer.valueOf(minNum));
//        Integer[] integers = list.stream().toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,3,2,1})));
    }
}
