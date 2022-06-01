public class StringSortingUsingTrie {
    // string 배열이 주어 졌을때, 알파벡 순서대로 출력. 중복된 값이 있다면 한번만 출력.
    /*
    Trie란 : efficient information retreival data structure using which search complexities can be brought to optimal limit.
    string과 같은 데이터를 저장하는데 사용되는 효율적인 data structure이다.
    알파벳 순서대로 string을 출력하기 위해서, trie에 먼저 insert해야하고, 알파벳 순서대로 출력하기 위해서 preorder traversal를 해야한다.
     */
    // 알파벳 크기
    static final int MAX_CHAR = 26;
    // Trie 노드 : 안에는 크기가 26인 child[]배열이 있고, index가 있다. (leaf 노드를 제외하고는 -1)
    static class Trie{
        // 노드가 leaf 노드일때 설정. 안그러면 -1;
        int index;
        Trie[] child = new Trie[MAX_CHAR];
        // 새 trie 만드는 방법
        Trie(){
            for (int i = 0; i < MAX_CHAR; i++) {
                this.child[i] = null;
            }
            this.index = -1;
        }
    }
    // trie에 삽입하는 function
    static void insert(Trie root, String str, int index){
        Trie node = root;
        for (int i = 0; i < str.length() ; i++) {
            // 아스키 코드 값을 사용해 child node의 index를 찾는다.
            int ind = str.charAt(i) - 'a';
            // 준비가 안되었다면 새로운 path 생성
            if (node.child[ind] == null) node.child[ind] = new Trie();
            // 다음 노드로 이동
            node = node.child[ind];
        }
        // leaf (단어의 끝)을 표시하고 저장
        // 단어에서 arr[]의 index
        node.index = index;
    }
    // preorder traversal 하는 function
    static boolean preorder(Trie node, String[] arr){
        if (node == null) return false;
        for (int i = 0; i < MAX_CHAR; i++) {
            // 글자가 node에 있다면,
            if (node.child[i] != null){
                // leaf node라면 key를 출력해라
                if (node.child[i].index != -1){
                    System.out.print(arr[node.child[i].index] + " ");
                }
                // 재귀로 다시 leaf 도달할때 까지 검색.
                preorder(node.child[i], arr);
            }
        }
        return false;
    }
    static void printSorted(String[] arr, int n){
        Trie root = new Trie();
        // 모든 dictionary의 key를 trie로 삽입
        // root라는 하나의 trie에 string들을 계속 만드는 것.
        for (int i = 0; i < n; i++) {
            insert(root, arr[i], i);
        }
        // 사전상의 순서로 key를 출력
        preorder(root,arr);
    }
    public static void main(String[] args) {
        String[] arr = { "abc", "xy", "bcd" };
        int n = arr.length;
        printSorted(arr, n);
    }
}
