import java.util.Scanner;
import java.util.Stack;

class StackAndQueue5 {

    int solution(String str) {
        int answer = 0;
        // 인접하면 레이저
        // 레이저 부분에서 (개수 만큼 answer에 더해주고, 닫히면 +1씩 해주기.
        Stack<Character> stack = new Stack<>();
        int openBracket = 0;
        for (char x : str.toCharArray()) {
            if (x == '('){
                openBracket++;
                stack.push(x);
            }
            // 레이저 일때
            if (stack.peek()=='(' && x == ')'){
                stack.pop();
                stack.push(')');
                openBracket--;
                answer += openBracket;
            } // ) 닫힐때.
            else if (x == ')') {
                answer += 1;
                openBracket--;
            }
        }
        return answer;
    }
    // 강사풀이
    int solution1(String str) {
        // stack에 ( 만나면 무조건 push. ) 만났을때 peek()통해서 (면 lasor. pop하고 (개수 만큼 answer에 더해주기
        // 레이저 아닌 )면 pop시켜서 (개수 줄이기. answer++
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('(');
            else{
                stack.pop();
                if (str.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        StackAndQueue5 T = new StackAndQueue5();
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(T.solution(string));
    }
}
