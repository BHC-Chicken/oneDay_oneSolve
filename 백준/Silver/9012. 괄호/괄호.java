import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> strings = new Stack<>();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            String token = br.readLine();
            int length = token.length();
            strings.clear();

            try {
                for (int a = 0; a < length; a++) {
                    if (token.charAt(a) == '(') {
                        strings.push(token.charAt(a));
                    } else if (token.charAt(a) == ')'){
                        strings.pop();
                    }
                }
            } catch (EmptyStackException e) {
                sb.append("NO").append("\n");
                continue;
            }

            if (strings.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}