import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] tokens = br.readLine().split(",");
            HashMap<String, Integer> hashMap = new HashMap<>();
            int min = Integer.MAX_VALUE;

            for (String token : tokens) {
                StringTokenizer st = new StringTokenizer(token, ":");

                String key = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                hashMap.put(key, value);
            }

            String[] sheTokens = br.readLine().split("\\|");

            for (String token : sheTokens) {
                StringTokenizer st = new StringTokenizer(token, "&");
                int sum = Integer.MIN_VALUE;

                while (st.hasMoreTokens()) {
                    String key = st.nextToken();

                    sum = Math.max(sum, hashMap.get(key));
                }

                min = Math.min(sum, min);
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
