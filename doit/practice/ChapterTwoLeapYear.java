public class ChapterTwoLeapYear {
    static final int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };
    static int isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }
    static int dayOfYear(int y, int m, int d) {
        // d일에 그 해 결과 일 수를 구함
        int days = d;
        for (int i = 0; i < m ; i++) days += mdays[isLeap(y)][i -1];
        return days;
    }
    static int dayOfYear1(int y, int m, int d) {
        // d일에 그 해 결과 일 수를 구함
        // y가 윤년이냐 아니냐, m-1 까지 day수 합한 다음 d 더하기.
        while (--m !=0){
            d += mdays[isLeap(y)][m-1];
        }
        return d;
    }
    static int leftDayOfYear(int y, int m, int d){
        int leftDay =  mdays[isLeap(y)][m-1] -d;
        while ( ++m  != 13){
            leftDay += mdays[isLeap(y)][m-1];
        }
        return leftDay;
    }

    public static void main(String[] args) {
        System.out.println(leftDayOfYear(2022,12,29));
    }
}
