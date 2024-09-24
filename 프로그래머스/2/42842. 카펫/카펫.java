class Solution {
    public int[] solution(int brown, int yellow) {
        int first = (brown / 2) - 1;
        int second = 1;
        
        while(true) {
            if(((first - 2) * second) == yellow) {
                
                break;
            } else {
                first -= 1;
                second += 1;
            }
        }
        
        int[] answer = {first, second + 2};
        
        return answer;
    }
}