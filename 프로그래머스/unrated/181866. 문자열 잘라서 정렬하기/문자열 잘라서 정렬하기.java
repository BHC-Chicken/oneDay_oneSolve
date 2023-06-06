import java.util.StringTokenizer;
import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        StringTokenizer st = new StringTokenizer(myString, "x");
        String[] answer = new String[st.countTokens()];
        int index = 0;
        
        while (st.hasMoreTokens()) {
            answer[index] = st.nextToken();
            index++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}