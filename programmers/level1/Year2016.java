import java.util.Calendar;

// LocalDate와 Calendar 공부하기
public class Year2016 {
    static final String[] DAY_OF_WEEK = {"", "SUN","MON","TUE","WED","THU","FRI","SAT"};
//    static final String[] DAY_OF_WEEK = {"", "THU","FRI","SAT","SUN","MON","TUE","WED"};
    static public String solution(int a, int b) {
        Calendar date = Calendar.getInstance();
        date.set(2016,a-1,b);
        return DAY_OF_WEEK[date.get(Calendar.DAY_OF_WEEK)];
    }
    public static void main(String[] args) {
        System.out.println(solution(1,1));

    }
}
