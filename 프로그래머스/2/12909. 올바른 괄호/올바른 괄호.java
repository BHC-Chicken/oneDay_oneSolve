import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (stack.isEmpty() && c == ')') {
                return false;
            }
            
            if (c == ')') {
                stack.poll();
            } else {
                stack.add(c);
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}