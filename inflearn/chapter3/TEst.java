import java.util.ArrayList;
import java.util.List;

class TEst {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("100");
        list.add("200");
        list.add("300");
        String memberId = "100";

        String s = list.get(1);
        String s1 = list.get(1);
        System.out.println(s == s1);

    }

}
