class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skills = new int[26];

        int index = 1;
        for(int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);

            skills[c - 'A'] = index++;
        }

        for (int i = 0; i < skill_trees.length; i++) {
            index = 1;
            boolean success = true;
            String now = skill_trees[i];

            for (int j = 0; j < now.length(); j++) {
                if (skills[now.charAt(j) - 'A'] == 0) {
                    continue;
                }

                if (skills[now.charAt(j) - 'A'] == index) {
                    index++;
                } else {
                    success = false;

                    break;
                }
            }

            if (success) {
                answer++;
            }
        }
        
        return answer;
    }
}