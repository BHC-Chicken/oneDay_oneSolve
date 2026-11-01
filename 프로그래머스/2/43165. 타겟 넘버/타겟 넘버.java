class Solution {
    int answer;
    
    void dfs(int target, int[] numbers, int depth, int now) {
        if (depth == numbers.length) {
            if (now == target) {
                answer++;   
            }
            
            return;
        }
        
        
        dfs(target, numbers, depth + 1, now + numbers[depth]);
        dfs(target, numbers, depth + 1, now - numbers[depth]);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(target, numbers, 0, 0);
        
        return answer;
    }
}