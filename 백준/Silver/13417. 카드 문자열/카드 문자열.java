import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int front, back;
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            int length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            front = s.codePointAt(0);
            back = s.codePointAt(0);

            deque.add(s);

            for (int j = 0; j < length - 1; j++) {
                s = st.nextToken();
                if (s.codePointAt(0) <= front) {
                    front = s.codePointAt(0);
                    deque.addFirst(s);
                } else if (s.codePointAt(0) > back) {
                    back = s.codePointAt(0);
                    deque.addLast(s);
                } else {
                    deque.addLast(s);
                }
            }

            for (String t : deque) {
                sb.append(t);
            }
            System.out.println(sb);
            sb.setLength(0);
            deque.clear();
        }
    }
}
