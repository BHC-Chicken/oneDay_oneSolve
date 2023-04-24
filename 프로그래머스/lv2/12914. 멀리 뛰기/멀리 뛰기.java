class Solution {
    public long solution(int n) {
        long[] arr = new long[2001];
        
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i = 2; i < 2001; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        
        return arr[n];
    }
}