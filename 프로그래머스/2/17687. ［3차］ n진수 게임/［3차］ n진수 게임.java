class Solution {
    String conversion(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        int start = p - 1; 
        
        for (int i = 0; i < t; i++) {
            result.append(sb.charAt(start));
            
            start += m;
        }
        
        return result.toString().toUpperCase();
    }
    
    public String solution(int n, int t, int m, int p) {
        String answer = conversion(n, t, m, p);
        
        return answer;
    }
}