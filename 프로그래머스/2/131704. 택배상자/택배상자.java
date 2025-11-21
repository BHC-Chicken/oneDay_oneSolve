import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int currentBox = 1;

        for (int target : order) {
            while (currentBox <= target) {
                stack.push(currentBox);
                currentBox++;
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
            } else {

                break;
            }
        }
        
        return answer;
    }
}