public class StringSortingByLength {

    // 길이에 따라서 sorting.
    static void sort(String[] arr, int n){
        for (int i = 1; i < n ; i++) {
            String temp = arr[i];

            // arr[j]를 알맞은 위치에 삽입
            int j = i-1;
            while(j >=0 && temp.length() < arr[j].length()){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }

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
