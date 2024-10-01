import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int last = 0;
        int totalIndex = 27;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < msg.length(); i++) {
            map.put(String.valueOf(msg.charAt(i)), msg.charAt(i) - 'A' + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < msg.length(); i++) {
            int index = 1 + i;
            
            for (int j = i; j < msg.length(); j++) {
                if(map.get(msg.substring(i,index)) == null) {
                    map.put(msg.substring(i, index), totalIndex++);
                    list.add(map.get(msg.substring(i, index - 1)));
                    
                    last = index - 1;
                    
                    i += msg.substring(i, index - 1).length() - 1;
                    
                    break;
                } else {
                    index++;
                }
            }
        }
        
        list.add(map.get(msg.substring(last, msg.length())));
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}