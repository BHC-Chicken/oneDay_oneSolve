import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        while (test_case-- > 0) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int kind = Integer.parseInt(br.readLine());
            int result = 1;

            for (int i = 0; i < kind; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if (hashMap.containsKey(key)) {
                    int temp = hashMap.get(key);
                    hashMap.put(key, temp + 1);
                } else {
                    hashMap.put(key, 1);
                }
            }

            for (int i : hashMap.values()) {
                result *= i + 1;
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}