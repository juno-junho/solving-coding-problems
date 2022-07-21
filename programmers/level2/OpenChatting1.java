import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChatting1 {
    // String의 ignareCase() 메소드
    // Inner class 만들때 private 클래스 선언. 객체지향 정확히 알기.
    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";

    private HashMap<String, UserInfo> userMap = new HashMap<>();
    // Userid랑 userInfo 넣음.

    private class UserInfo{
        public String userId;
        public String nickName;

        public UserInfo(String userId, String nickName) {
            this.userId = userId;
            this.nickName = nickName;
        }
    }
    private class Command{
        public char command; // E , L
        public String userId;

        public Command(char command, String userId) {
            this.command = command;
            this.userId = userId;
        }
    }
    public String[] solution(String[] records){
        List<Command> commandList = new ArrayList<>();
        for (String record : records) {
            String[] words = record.split(" ");
            String command = words[0];
            String userId = words[1];
            String nickName;

            switch (command.charAt(0)){
                case 'E':
                    nickName = words[2];
                    // 새로들어오는 id이면 만들어주고
                    if (!userMap.containsKey(userId)) userMap.put(userId, new UserInfo(userId,nickName));
                    // 새로들어오는 id가 아니면 닉네임 변경해주기
                    else userMap.get(userId).nickName = nickName;
                    commandList.add(new Command((command.charAt(0)), userId));
                    break;
                case 'L' :
                    commandList.add(new Command(command.charAt(0), userId));
                    break;
                case 'C' :
                    nickName = words[2];
                    userMap.get(userId).nickName = nickName;
                    break;
            }
        }
        return commandList.stream()
                .map(cmd -> String.format(cmd.command == 'E'? ENTER_FORMAT : LEAVE_FORMAT, userMap.get(cmd.userId).nickName))
                .toArray(String[]::new);
    }
}


