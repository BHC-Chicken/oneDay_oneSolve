import java.util.Stack;

class Solution {
    public int solution(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (sb.charAt(j) == '(' || sb.charAt(j) == '{' || sb.charAt(j) == '[') {
                    stack.push(sb.charAt(j));
                } else {
                    char temp = ' ';
                    if (!stack.empty()) {
                        temp = stack.pop();
                        if (temp == '(' && sb.charAt(j) != ')' ||
                                temp == '{' && sb.charAt(j) != '}' ||
                                temp == '[' && sb.charAt(j) != ']') {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                count++;
            }

            if (count == s.length() && stack.isEmpty()) {
                result++;
            }

            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        
        return result;
    }
}