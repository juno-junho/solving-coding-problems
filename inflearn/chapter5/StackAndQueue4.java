import java.util.Scanner;
import java.util.Stack;

class StackAndQueue4 {
    // stack은 운동장에 구덩이라 생각하면된다.ㄹ
    int solution(String str) {
        Stack<Integer> stack = new Stack();
        for (char x : str.toCharArray()) {
            // 숫자면 stack에 넣기
            if (Character.isDigit(x)) stack.push(x - 48);
            else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (x){
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }

        return stack.get(0);
    }
    public static void main(String[] args) {
        StackAndQueue4 T = new StackAndQueue4();
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(T.solution(string));
    }
}
