import java.util.Arrays;

public class WallpaperArrangement {

    public int[] solution(String[] wallpaper) {
        int lux = 0;
        int luy = 0;
        int rdx = 0;
        int rdy = 0;

        // lux : 파일 가장 먼저 있는 string index
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                lux = i;
                break;
            }
        }

        //luy : 가장 먼저 string 값에서 파일이 발견되는 string의 index
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    min = Math.min(j, min);
                }
            }
        }
        luy = min;

        // rdx : 파일이 가장 마지막에 있는 string index
        for (int i = wallpaper.length; i > 0; i--) {
            if (wallpaper[i - 1].contains("#")) {
                rdx = i;
                break;
            }
        }

        // rdy : 가장 마지막에 string 값에서 파일이 발견되는 string의 index
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = wallpaper[0].length(); j > 0; j--) {
                if (wallpaper[i].charAt(j - 1) == '#') {
                    max = Math.max(max, j);
                }
            }
        }
        rdy = max;

        return new int[] {lux, luy, rdx, rdy};
    }

    /**
     * 정답 : 좌표로 한번에 해결..
     *
     */
    public int[] solution2(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }
    public static void main(String[] args) {
        WallpaperArrangement arrangement = new WallpaperArrangement();
        String[] str = {"..", "#."};

        int[] solution = arrangement.solution(str);
        System.out.println(Arrays.toString(solution));
    }

}
