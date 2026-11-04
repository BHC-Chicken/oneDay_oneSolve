import java.util.*;

class Solution {
    int answer;
    List<List<Integer>> graph = new ArrayList<>();
    
    int dfs(int current, int parent, int n) {
        int sub = 1;
        
        for (int next : graph.get(current)) {
            if (next != parent) {
                sub += dfs(next, current, n);
            }
        }
        
        if (parent != 0) {
            int diff = Math.abs(n - 2 * sub);
            answer = Math.min(diff, answer);
        }
        
        return sub;
    }
    
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        dfs(1, 0, n);

        return answer;
    }
}