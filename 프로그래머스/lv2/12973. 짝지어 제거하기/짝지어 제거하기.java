import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            String c = String.valueOf(sb.charAt(i));
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}