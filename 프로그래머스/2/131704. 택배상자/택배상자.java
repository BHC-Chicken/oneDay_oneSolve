import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            stack.push(i);

            while (!stack.isEmpty()) {
                if (stack.peek() == order[index]) {
                    stack.pop();
                    index++;
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}