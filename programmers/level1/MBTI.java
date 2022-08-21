import java.util.HashMap;

public class MBTI {
    static String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);


        for (int i = 0; i < survey.length; i++) {
            char character = survey[i].charAt(0);
            char character2 = survey[i].charAt(1);
            switch (choices[i]){
                case 1:
                    map.put(character,map.get(character) + 3);
                    break;
                case 2:
                    map.put(character,map.get(character) + 2);
                    break;
                case 3:
                    map.put(character,map.get(character) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(character2,map.get(character2) + 1);
                    break;
                case 6:
                    map.put(character2,map.get(character2) + 2);
                    break;
                case 7:
                    map.put(character2,map.get(character2) + 3);
                    break;
            }
        }
        System.out.println(map.get('R'));
        System.out.println(map.get('T'));
        System.out.println(map.get('C'));
        System.out.println(map.get('F'));
        System.out.println(map.get('J'));
        System.out.println(map.get('M'));
        System.out.println(map.get('A'));
        System.out.println(map.get('N'));

        String answer = "";
        if(map.get('R') >= map.get('T')) answer += "R";
        else answer += "T";

        if(map.get('C') >= map.get('F')) answer += "C";
        else answer += "F";

        if(map.get('J') >= map.get('M')) answer += "J";
        else answer += "M";

        if(map.get('A') >= map.get('N'))answer += "A";
        else answer += "N";

        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN","AN", "CF", "MJ", "RT", "NA"}, new int[]{5,6, 3, 2, 7, 5}));

    }
}
