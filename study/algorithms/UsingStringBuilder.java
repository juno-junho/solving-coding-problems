public class UsingStringBuilder {
    /**
     *  String joinWord(String[] words){
     *      String sentence = "";
     *      for(String w : words){
     *          sentence += w;
     *      }
     *  }
     * -> 매우 비효율적임.
     *  시간 복잡도 : x + 2x + 3x .. (x는 word의 길이)
     * -> O(xn^2)
     * 이것을 효과적으로 해결하기위해서 StringBuilder를 제공함.
     * StringBuilder는 class안에 배열 공간 미리 만들어 놓고 append시 바로 추가.
     * 배열공간 부족하면 그때만 공간 늘려서 복사하는 방식. 복사하는 횟수가 현저히 줄어듬
     * StringBuffer는 StringBuilder에 비해서 동기화를 보장함.
     * -> 속도는 Stringbuilder보다 느리지만 multi Thread환경이라면 동기화를 보장하기 위해서 StringBuffer를 사용해야한다.
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("junho");
        sb.append("hwang");
        System.out.println(sb.toString());
    }
}

class StringBuilder {
    private char[] value;   // 문자열 저장할 char 배열
    private int size;   // 배열 방의 크기
    private int index;  // 새로추가될 char에 방번호를 기억하고 있을 변수
    StringBuilder(){
        size = 1;
        value = new char[size];
        index = 0;
    }

    public void append(String str) {
        if (str == null) str = "null";  // null들어올시
        int len = str.length();
        ensureCapacity(len); // 배열방 넉넉한지 확인
        for (int i = 0; i < str.length(); i++) {
            value[index++] = str.charAt(i);
        }
    }
    private void ensureCapacity(int len) {
        if (index + len > size) {   // 현재 index에 문자열 길이 더했을때 현재 배열방 길이 초과시 사이즈 늘려주기
            size = (size + len) * 2;
            char[] newValue = new char[size];
            for (int i = 0; i < value.length; i++) {
                newValue[i] = value[i];
            }
            value = newValue;
        }
    }
    public String toString() {
        return new String(value, 0, index);
    }
}