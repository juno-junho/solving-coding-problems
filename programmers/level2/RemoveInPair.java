import java.util.Stack;
// 문제를 잘못 이해함...
// 짝짓는다는 말이 같은 알파벳 2개 붙어 있는 것. 3개는 안되는 거구나.. 그래서 stack에서 push랑 pop으로 구현할수 있었던것.

public class RemoveInPair {
//    static int solution(String s) {
//        // 접근 방법 : s char로 전환 한 다음, temp로 설정하면서 붙어있는것 찾아서 삭제한다.
//        // 근데 삭제를 어떻게 시킬건데.. -> 연속된것만 빼고 sb에 추가하기.
//        // 그리고 그 걸 계속 반복한다. 만약 그 삭제 과정을 거쳤는데 원래 chars와 동일하다면 -1 반환
//
//        StringBuilder sb = new StringBuilder() ;
//
//        // a b c a a a a
//        int count = 0;
//        while (!s.equals(new String(sb))){ // sb과 기존의 것이 동일하다면
//
//            for (int i = 0; i < s.length() -1; i++) {
//                // 다음 것과 비교
//                // count 통해서 연속된 index 중인지 확인.
//
//                if (s.charAt(i) == s.charAt(i+1)) {
//                    count ++;
//                    // 끝이 같으면?
//                }
//                // 다음문자랑 같지 않지만 연속된 것일 경우, 0으로 초기화해주고 다음 인덱스들 다 붙히고 나가기
//                else if (count > 0){
//                    sb.append(s.substring(i+1));
//                    break;
//                }
//                // index + 1과 문자 동일 x -> 추가해준다.
//                else sb.append(s.charAt(i));
//            }
//            // 마지막 추가해주기
//            if (count == 0) sb.append(s.charAt(s.length()-1));
//            // sb의 길이가 0이면 return 1
//            if (sb.length() == 0) return 1;
//            if (s.equals(sb.toString())) return 0;
//            count = 0;
//            s = new String(sb);
//            sb = new StringBuilder();
//       }
//        return 0;
//
//    }
    static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        // b a a a b
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() &&stack.peek() == s.charAt(i)) {
                stack.pop();
            }else stack.push(s.charAt(i));
        }
        int answer = -1;
        answer = (stack.size() == 0) ? 1 : 0;
        return answer;

//        do {
//            stack.removeAllElements();
//            chars = s.toCharArray();
//            stackSize = stack.size();
//            for (int i = 0; i < chars.length; i++) {
//                if (!stack.isEmpty() &&stack.peek() == chars[i]) {
//                    stack.pop();
//                    count++;
//                    continue;
//                }
//                // 똑같진 않지만 count 가 0이 아니다
//                stack.add(chars[i]);
//            }
//            if (stack.size() == stackSize) return 0;
//        } while(!stack.isEmpty());
//        return 1;

    }
    public static void main(String[] args) {
        System.out.println(solution("baaab"));
//        System.out.println("a");
    }
}
