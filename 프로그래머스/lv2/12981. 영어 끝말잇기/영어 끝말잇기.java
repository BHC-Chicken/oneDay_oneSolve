import java.util.HashSet;

class Solution {
    static int turn = 1;
    static int num = 1;
    
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int[] answer = new int[2];
        
        for(int i = 1; i < words.length; i++) {
            turn++;
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                answer[0] = turn;
                answer[1] = num;
                return answer;
            } else if(set.contains(words[i])) {
                answer[0] = turn;
                answer[1] = num;
                return answer;
            } else {
                set.add(words[i]);
            }
            if (turn == n) {
                num++;
                turn = 0;
            }
        }
        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }
}