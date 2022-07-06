public class ChapterTwoArray {
    static boolean equals(int[] a, int[] b){
        if(a.length != b.length) return false;
        for (int i = 0; i < a.length ; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    static void copy(int[] a, int[] b){
        //b의 모든 요소를 a에 복사
        int num = Math.min(a.length, b.length);
        for (int i = 0; i < num ; i++) {
            a[i] = b[i];
        }
    }
    static void rcopy(int[] a, int[] b){
        // 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 rcopy 메소드
        int num = Math.min(a.length, b.length);
        for (int i = 0; i < num ; i++) {
            a[i] = b[a.length-1-i];
        }
    }
}
