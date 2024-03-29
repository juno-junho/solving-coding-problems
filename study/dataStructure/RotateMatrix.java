class RotateMatrix {
    public static void main(String[] args) {
        int[][] image = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        printImage(image);
        rotateImage(image);

        printImage(image);
        rotateImage(image);

        printImage(image);
        rotateImage(image);

        printImage(image);
        rotateImage(image);

        printImage(image);
        rotateImage(image);
    }

    /**
     * Loop : s = 0, e = 4
     *  s ++, e--
     *  Loop : i = s -> e
     *         j = e -> s
     *         tmp = [s][i]
     *         [s][i] = [i][e]
     *         [i][e] = [e][j]
     *         [e][j] = [j][s]
     *         [j][s] = tmp
     */
    private static int[][] myCode(int[][] image) {
        for (int s = 0, e = image.length - 1; s < e; s++, e--) {
            int tmp;
            for (int i = s, j = e; i < e; i++, j--) {
                tmp = image[s][i];
                image[s][i] = image[i][e];
                image[i][e] = image[e][j];
                image[e][j] = image[j][s];
                image[j][s] = tmp;
            }
        }
        return image;
    }

    private static int[][] rotateImage(int[][] image) {
        int tmp;
        for (int s = 0, e = image.length - 1; s < e; s++, e--) {
            for (int i = s, j = e; i < e; i++, j--) {
                tmp = image[s][i];
                image[s][i] = image[i][e];
                image[i][e] = image[e][j];
                image[e][j] = image[j][s];
                image[j][s] = tmp;
            }
        }
        return image;
    }

    private static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
