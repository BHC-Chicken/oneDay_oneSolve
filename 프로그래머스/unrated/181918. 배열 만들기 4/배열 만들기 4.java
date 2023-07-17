import java.io.IOException;
import java.util.Stack;


class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else if (stack.peek() < arr[i]) {
                stack.add(arr[i]);
            } else if (stack.peek() >= arr[i]){
                stack.pop();
                i--;
            }
        }
        int[] stk = new int[stack.size()];
        int index = 0;

        for (int i : stack) {
            stk[index] = i;
            index++;
        }
        return stk;
    }
}