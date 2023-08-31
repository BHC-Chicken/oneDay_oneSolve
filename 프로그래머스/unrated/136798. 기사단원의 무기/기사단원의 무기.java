class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int sqrt = (int) Math.sqrt(i);
            int count = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    count++;
                    if (i / j != j) {
                        count++;
                    }
                }
            }

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }
}