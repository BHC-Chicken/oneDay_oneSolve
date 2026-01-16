class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pronunciations = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            if (word.contains("ayaaya") || word.contains("yeye") || 
                word.contains("woowoo") || word.contains("mama")) {
                continue;
            }

            for (String p : pronunciations) {
                word = word.replace(p, " ");
            }
            
            if (word.trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}