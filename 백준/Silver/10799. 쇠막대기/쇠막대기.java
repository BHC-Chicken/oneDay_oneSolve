import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (word.charAt(i) == ')') {
                stack.pop();

                if (word.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
