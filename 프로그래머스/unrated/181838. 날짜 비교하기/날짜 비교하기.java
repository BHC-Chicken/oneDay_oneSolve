class Solution {
    public int solution(int[] date1, int[] date2) {
        StringBuilder day1 = new StringBuilder();
        StringBuilder day2 = new StringBuilder();
        
        for (int i : date1) {
            day1.append(i);
        }
        
        for (int i : date2) {
            day2.append(i);
        }
        
        if (Integer.parseInt(day1.toString()) < Integer.parseInt(day2.toString())) {
            return 1;
        }
        
        return 0;
    }
}