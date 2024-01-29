import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<int[]> st = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int current = Integer.parseInt(stz.nextToken());

            while (!st.empty()) {
                if (st.peek()[1] < current) {
                    st.pop();
                } else {
                    sb.append(st.peek()[0]).append(" ");

                    break;
                }
            }
            if (st.isEmpty()) {
                sb.append("0 ");
            }
            st.push(new int[]{i, current});
        }

        System.out.println(sb);
    }
}
