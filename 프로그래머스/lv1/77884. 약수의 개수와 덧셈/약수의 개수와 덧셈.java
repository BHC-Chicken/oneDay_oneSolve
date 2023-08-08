import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            List<Integer> list = new ArrayList<>();
            for(int j = 1; j <= sqrt; j++){
                if(i % j == 0){
                    list.add(j);
                    if(i / j != j){
                        list.add(i / j);
                    }
                }
            }
            if (list.size() % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
    
        return answer;
    }
}