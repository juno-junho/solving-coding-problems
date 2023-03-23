public class ArrayChapter {
    /**
     * java - array가 fixed되어있음.
     * ArrayList - 추가 하는대로 size가 늘어남.
     * 검색시간 : O(1) - 배열 다 차면 2배로 늘려주기 때문에. 검색할때는 여전히 고정된 배열에서 검색.
     * doubling 시간 : O(N)
     * 값 끝에 추가하는것 : O(1) but doubling 할때는 O(N)

     * 정리)
     * ArrayList는 **평균적으로**
     * 입력시간 : O(1)
     * 검색시간 : O(1)
     */

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        System.out.println(arrayList.get(5));

        Object remove = arrayList.remove(5);
        System.out.println("data removed: " + remove);

        System.out.println(arrayList.get(5));

    }
}
class ArrayList{
    private Object[] data;
    private int size;   // 크기
    private int index; // 다음 데이터 추가 위치 기억

    public ArrayList() {
        this.size = 1;
        this.data = new Object[this.size];
        this.index = 0;
    }

    public void add(Object obj) {
        System.out.println("index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
        if (this.size - 1 == this.index) {
            // 2배 늘리고 원래값들 복사
            doubling();
        }
        this.data[this.index] = obj;
        this.index++;
    }

    private void doubling() {
        this.size = size * 2;
        Object[] newData = new Object[this.size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
//        System.arraycopy(data, 0, newData, 0, data.length);
        this.data = newData;
        System.out.println("After doubling ** index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
    }

    // index 번호를 가지고 data 가져오는 함수
    public Object get(int index) {
        if (index > this.index - 1) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOufBound");
        } else if (index < 0) {
            throw new NegativeArraySizeException("Negative Value");
        }
        return this.data[index];
    }

    // index 번호로 삭제하는 함수
    public Object remove(int index) {
        if (index > this.index - 1) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOufBound");
        } else if (index < 0) {
            throw new NegativeArraySizeException("Negative Value");
        }
        Object removedData = this.data[index];
        // index 이전은 놔두고 이후는 한칸씩 당겨야함
        for (int i = index; i < this.data.length - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.index--;
        return removedData;
    }
}
