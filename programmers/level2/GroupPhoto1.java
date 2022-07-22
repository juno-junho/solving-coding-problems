public class GroupPhoto1 {
    static int count;
    static int solution(int n, String[] data) {
        count = 0;
        String str = "ACFJMNRT";
        solution("", str,n,data);
        return count;
    }
    static void solution(String prefix, String str, int n, String[] data) {
        if (str.length() == 0){
            boolean flag = true;
            for (int i = 0; i < n; i++) { // 조건 수 만큼 돌기.
                int index1 = prefix.indexOf(data[i].charAt(0));// 첫째글자의 index
                int index2 = prefix.indexOf(data[i].charAt(2));// 둘째 글자의 index
                switch (data[i].charAt(3)) {
                    case '=':
                        if ((Math.abs(index1 - index2)-1) != Character.getNumericValue(data[i].charAt(4))) flag = false;
                        break;
                    case '>':
                        if ((Math.abs(index1 - index2)-1) <= Character.getNumericValue(data[i].charAt(4))) flag = false;
                        break;
                    case '<':
                        if ((Math.abs(index1 - index2)-1) >= Character.getNumericValue(data[i].charAt(4))) flag = false;
                        break;
                }
                if (!flag) break;
            }
            if (flag) count++;
        }
        else {
            for (int i = 0; i < str.length(); i++)
                solution(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()), n, data);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(2,new String[]{"N~F=0", "R~T>2"}));
    }
}
