import java.util.*;

class Solution {
    void removeServer(Queue<Integer> q) {
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int num = q.poll() - 1;
            
            if (num >= 1)  {
                q.add(num);
            }
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int full = m;
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < players.length; i++) {
            int player = players[i];

            if (full > player) {
                removeServer(q);
                full = m + (q.size() * m);
                continue;
            }

            int remain = player - full;
            int plus = (remain / m) + 1;

            for (int j = 0; j < plus; j++) {
                q.add(k);
            }

            answer += plus;
            removeServer(q);
            full = m + (q.size() * m);
        }
        
        return answer;
    }
}
