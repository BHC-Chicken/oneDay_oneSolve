import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        while (n!=0) {
            list.add(n % 3);
            n /= 3;
        }
        int num = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            answer += (num * list.get(i));
            num *= 3;
        }
        
        return answer;
    }
}