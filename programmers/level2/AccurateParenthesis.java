import java.util.Stack;

public class AccurateParenthesis {
    boolean solution2(String s) {
        // stack 이용
        Stack<Boolean> stack = new Stack<>();
        try{
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(') stack.push(true);
                if(s.charAt(i) == ')') stack.pop();
            }
        }catch (Exception e){
            return false;
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
    boolean solution(String s) {
        boolean answer = true;
        // 너무 쉽다. s 하나하나 돌면서 (는 +1 ,)는 -1 로 계산.
        // 값이 0보다 작아 질 경우, 바로 return false;
        // 다 돌고 난 후 값이 0이 아닐경우 retrun false
        char[] chars = s.toCharArray();
        int count = 0 ;

        for (char aChar : chars) {
            if (aChar == '(') count++;
            if (aChar == ')') count--;
            if (count < 0 ) return false;
        }

        answer = count == 0 ? true : false;
        return answer;
    }
}
