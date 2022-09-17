class LinearSearch1 {
    static int seqSearch(int[] a, int n, int key) {
        int i = 0;
        while (true) {
            if (i == n) return -1;
            if (a[i] == key) return i;
            i++;
        }
/*
        // 동일

        for (int j = 0; j < n; j++) {
            if (a[j] == key) return j;
        }
        return -1;
*/
    }
}
