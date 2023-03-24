import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Q_1406_Fail {
    /**
     * 백준 1406번 - 에디터 문제
     * 한 줄로 된 간단한 에디터 구현하려고 한다.
     * 영어 소문자만 기록할 수 있는 편집기, 최대 600,000자까지 입력 가능하다.
     * cursor가 문장의 맨앞, 맨뒤, or 중간 임의의 곳에 위치가능.
     * 길이가 L인 문자열이 현재 편집기에 입력되어 있다면, 커서가 위치할 수 있는 곳은 L+1 가지 경우의 수가 있다.
     * L : 커서 왼쪽으로 한칸 (맨앞이면 무시)
     * D : 커서 오른쪽으로 한칸.
     * B : 커서 왼쪽 문자 삭제.
     * p $ : $라는 문자를 커서 왼쪽에 추가

     * 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.

     * 아래 코드는 시간복잡도 O(N)이므로 시간초과
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Scanner sc = new Scanner(System.in);
        // 문자열
        String str = br.readLine();

        List<Character> words = new LinkedList<>();
        for (char letter : str.toCharArray()) {
            words.add(letter);
        }

        int cursorIndex = words.size();

        int commandNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandNum; i++) {
            String command = br.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if (cursorIndex > 0) {
                        cursorIndex--;
                    }
                    break;
                case 'D':
                    if (cursorIndex < words.size()) {
                        cursorIndex++;
                    }
                    break;
                case 'B':
                    if ( cursorIndex > 0) {
                        words.remove(--cursorIndex);
                    }
                    break;
                case 'P':
                    char charToInsert = command.charAt(2);
                    words.add(cursorIndex++, charToInsert);
                    break;
            }
        }

  /*      for (Character word : words) {
            System.out.print(word);
        }*/
        for(Character chr : words) {
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}
