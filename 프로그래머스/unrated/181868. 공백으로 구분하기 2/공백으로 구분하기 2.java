import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        String[] answer = new String[list.size()];
        int index= 0;
        
        for (String s : list) {
            answer[index] = s;
            index++;
        }
        
        return answer;
    }
}