import java.util.*;

class Solution
{
    public int solution(String s)
    {   
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                
                stack.push(c);
                
                continue;
            }
            
            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}