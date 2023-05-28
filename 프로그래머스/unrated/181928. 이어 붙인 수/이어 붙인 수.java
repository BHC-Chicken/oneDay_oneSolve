class Solution {
    public int solution(int[] num_list) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        
        for(int i : num_list) {
            if (i % 2 == 0) {
                even.append(i);
            } else {
                odd.append(i);
            }
        }
        
        return Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
    }
}