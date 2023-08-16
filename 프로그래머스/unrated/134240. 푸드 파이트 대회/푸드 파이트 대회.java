class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int cal = food[i];
            int div = cal / 2;
            
            for (int j = 0; j < div; j++) {
                sb.append(i);
            }
        }
        answer.append(sb).append(0).append(sb.reverse());
        
        return answer.toString();
    }
}