import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String poem = br.readLine().toUpperCase();
        int space = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(poem);

        if (st.countTokens() - 1 > space) {
            System.out.println(-1);

            return;
        }

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            sb.append(s.charAt(0));
            arr[s.charAt(0) - 'A'] -= 1;
            int previous = -1;

            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'A';

                if (previous != index) {
                    arr[index] -= 1;
                    previous = index;
                }

                if (arr[index] < 0) {
                    System.out.println(-1);

                    return;
                }
            }
        }

        System.out.println(sb);
    }
}