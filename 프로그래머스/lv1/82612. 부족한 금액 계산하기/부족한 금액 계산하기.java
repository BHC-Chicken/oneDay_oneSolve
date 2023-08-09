class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalMoney = 0;
        
        for (int i = 1; i <= count; i++) {
            totalMoney += (price * i);
        }
        
        if (totalMoney <= money) {
            return 0;
        }
        
        totalMoney -= money;

        return totalMoney;
    }
}