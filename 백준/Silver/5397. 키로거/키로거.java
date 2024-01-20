import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            String password = br.readLine();

            ArrayList<Character> word = new ArrayList<>();
            Stack<Character> temp = new Stack<>();


            for (int j = 0; j < password.length(); j++) {
                char c = password.charAt(j);

                if (c == '<' && !word.isEmpty()) {
                    temp.push(word.get(word.size() - 1));
                    word.remove(word.size() - 1);
                } else if (c == '>' && !temp.isEmpty()) {
                    word.add(temp.pop());
                } else if (c == '-' && !word.isEmpty()) {
                    word.remove(word.size() - 1);
                } else if ((c >= 65 && 90 >= c) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)){
                    word.add(c);
                }
            }

            StringBuilder s = new StringBuilder();
            for (char c : temp) {
                s.append(c);
            }

            for (char c : word) {
                sb.append(c);
            }
            sb.append(s.reverse());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
