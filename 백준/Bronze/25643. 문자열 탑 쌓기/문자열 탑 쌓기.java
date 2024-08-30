import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isStack(String a, String b) {
        for (int i = 1; i <= a.length(); i++) {
            if (a.startsWith(b.substring(a.length() - i)) || b.startsWith(a.substring(a.length() - i))) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (int i = 1; i < n; i++) {
            String prevWord = words[i - 1];
            String curWord = words[i];

            if (!isStack(prevWord,curWord)) {
                System.out.println(0);

                return;
            }
        }

        System.out.println(1);
    }
}
