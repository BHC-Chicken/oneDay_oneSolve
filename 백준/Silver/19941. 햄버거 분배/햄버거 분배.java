import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        String word = br.readLine();
        
        char[] list = word.toCharArray();
        boolean[] booleans = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (list[i] == 'P') {
                int start = Math.max(i - m, 0);
                int end = Math.min(i + m, n - 1);
                for (int j = start; j <= end; j++) {
                    if (list[j] == 'H' && !booleans[j]) {
                        booleans[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}