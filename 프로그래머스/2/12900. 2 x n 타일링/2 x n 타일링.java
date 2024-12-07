class Solution {
    public int solution(int n) {
        long[] dp = new long[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        
        for (int i = 5; i <= n; i++) {
            long temp = (dp[i - 1]%1000000007) + (dp[i - 2]%1000000007);
            dp[i] = temp % 1000000007;
        }
        
        return (int) dp[n] ;
    }
}