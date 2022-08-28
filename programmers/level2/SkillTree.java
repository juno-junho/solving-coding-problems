public class SkillTree {
    // 다른 사람 풀이 공부
    static int solution(String skill, String[] skill_trees) {
        int[] alphabet = new int[26];
        int order = 1;
        for (int i = 0; i < skill.length(); i++) {
            alphabet[skill.charAt(i) -65] = order;
            order++;
        }

        boolean count = true;
        int answer = 0;
        for (String skill_tree : skill_trees) {
            order = 1;
            for (int i = 0; i < skill_tree.length(); i++) {
                // 스킬트리 순서대로 빼자. 스킬포함 안되있는것은 0. 나머지 스킬 포함되 있는 것들 중,
                // 0인것은 무시하고, 1로 시작안하면, 그냥 나가기. 1로 시작하면 num 올려줘서
                int orderNum = alphabet[skill_tree.charAt(i) - 65];
                if (orderNum !=0 && orderNum != order){
                    count = false;
                    break;
                }
                if (orderNum !=0 && orderNum == order) order++;
            }
            if (count) answer++;
            count = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
