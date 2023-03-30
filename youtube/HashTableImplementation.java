import java.util.LinkedList;

public class HashTableImplementation {
    /**
     * key를 입력받아 hash algorithm을 통해 hashcode 생성.
     * (간단하게 key 문자열의 각 ascii 값 더해서 hashcode 만든다.)
     *
     * 그리고 고정된 판을 미리 만들어 놓고 key에 따라 위치에 값을 가져다 넣는것.
     * 따라서 고정된 크기의 배열 선언해야함.
     * (hashcode % size)를 배열방의 index로 환산.
     *
     * collision 생기는 경우를 대비해서,
     * 배열 방 안에 linkedlist를 선언하고, data에 배열 방에 할당 될 때마다 linkedList에 data추가
     * 검색 요청시 key -> hashcode -> 배열방 접근 -> linkedList 돌면서 찾는 data 가져오기
     */

    static class HashTable{
        class Node{
            private String key; // 검색할 key
            private String value; // 검색 결과

            public Node(String key, String value) {
                this.key = key;
                this.value = value;
            }

            public String value() {
                return value;
            }

            public void value(String value) {
                this.value =value;
            }
        }

        LinkedList<Node>[] data;

        public HashTable(int size) {
            this.data = new LinkedList[size];
        }

        int getHashCode(String key) {
            int hashCode = 0;
            for (char c : key.toCharArray()) {
                hashCode += c;
            }
            return hashCode;
        }

        int convertToIndex(int hashCode) {
            return hashCode % data.length;
        }

        Node searchKey(LinkedList<Node> list, String key) {
            if (list == null) {
                return null;
            }
            for (Node node : list) {
                if (node.key.equals(key)) {
                    return node;
                }
            }
            return null;
        }

        void put(String key, String value) {
            int hashCode = getHashCode(key);
            int index = convertToIndex(hashCode);
            LinkedList<Node> list = data[index];
            if (list == null) {
                list = new LinkedList<>();
                data[index] = list;
            }
            Node node = searchKey(list, key);
            if (node == null) {
                list.addLast(new Node(key, value));
            }else {
                node.value(value);
            }
        }

        // key로 data가져오기
        String get(String key) {
            int hashCode = getHashCode(key);
            int index = convertToIndex(hashCode);
            LinkedList<Node> list = data[index];
            Node node = searchKey(list, key);
            return node == null ? "Not Found" : node.value();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        hashTable.put("junho", "a");
        hashTable.put("hwang", "b");
        hashTable.put("kim", "c");
        hashTable.put("seonju", "d");
        System.out.println(hashTable.get("junho"));
        System.out.println(hashTable.get("hwang"));
        System.out.println(hashTable.get("kim"));
        System.out.println(hashTable.get("seonju"));
        System.out.println(hashTable.get("daf"));
    }
}
