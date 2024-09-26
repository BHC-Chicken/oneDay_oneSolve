class Solution {
    static int result;
    
    void dfs(int depth, int[] numbers, int target, int now) {
        if (depth == numbers.length) {
            if (now == target) {
                result += 1;
            }
            
            return;
        }
        
        dfs(depth+1, numbers, target, now + numbers[depth]);
        dfs(depth+1, numbers, target, now + (numbers[depth] * (-1)));
    }
    
    public int solution(int[] numbers, int target) {
        dfs(1, numbers, target, numbers[0]);
        dfs(1, numbers, target, numbers[0] * (-1));
        
        return result;
    }
}