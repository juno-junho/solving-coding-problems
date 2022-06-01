public class StringSortingByLength {

    // 길이에 따라서 sorting.
    static void sort(String[] arr, int n){
        for (int i = 1; i < n ; i++) {
            String temp = arr[i];

            // arr[j]를 알맞은 위치에 삽입
            int j = i-1;
            //i 인덱스 1번부터 돌면서 자기 이전 위치의 string과 비교해서 크기가 크면 자리 바꾼다. (temp로 담아두고 바꾸는 방식)
            // 그렇게
            while(j >=0 && temp.length() < arr[j].length()){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }
        /*
        {"GeeksforGeeeks", "I", "from", "am"}  {"GeeksforGeeeks", "GeeksforGeeeks", "from", "am"} {"I", "GeeksforGeeeks", "from", "am"}
        {"I", "from", "GeeksforGeeeks", "am"}

         */

    }
    // sorted array 출력
    static void printArraystring(String[] str, int n){
        for (int i = 0; i < n; i++) {
            System.out.println(str[i] + " ");
        }
    }
    public static void main(String[] args) {
        String[ ]arr = {"GeeksforGeeks", "I", "from", "am"};
        int n = arr.length;
        // sorting
        sort(arr,n);
        // Calling the function to print result
        printArraystring(arr,n);

    }
}
