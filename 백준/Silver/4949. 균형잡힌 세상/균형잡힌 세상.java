import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        while (true) {
            String word = br.readLine();

            if (word.equals(".")) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c == '(' || c == '[') {
                    stack.add(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        stack.add('n');

                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        stack.add('n');

                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
            stack.clear();
        }

        System.out.println(sb);
    }
}
