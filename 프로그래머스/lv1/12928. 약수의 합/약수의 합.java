import java.util.*;

class Solution {
    public int solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        List<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= sqrt; i++){
            if(n % i == 0){
                arr.add(i);
                if(n / i != i) {
                    arr.add(n / i);
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            answer += arr.get(i);
        }
        
        return answer;
    }
}