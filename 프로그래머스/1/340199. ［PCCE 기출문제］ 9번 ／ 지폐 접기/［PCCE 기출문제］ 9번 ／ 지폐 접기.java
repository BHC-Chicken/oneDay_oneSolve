class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int longX = Math.max(wallet[0], wallet[1]);
        int longY = Math.min(wallet[0], wallet[1]);

        int x = Math.max(bill[0], bill[1]);
        int y = Math.min(bill[0], bill[1]);

        while (longX < x || longY < y) {
            answer++;

            int tempX = x / 2;
            int tempY = y;

            x = Math.max(tempX, tempY);
            y = Math.min(tempX, tempY);
        }
        
        return answer;
    }
}