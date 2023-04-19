class Solution {
    public int solution(int n) {
        int count = 1;
        int answer = 1;
        while (count != n) {
            int sum = 0;
            for (int i = count; i <= n; i++) {
                sum += i;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) {
                    break;
                }
            }
            count++;
        }
        return answer;
    }
}