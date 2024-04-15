import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (!hash.containsKey(num)) {
                hash.put(num, position);
            } else {
                int value = hash.get(num);

                if (position != value) {
                    result++;

                    hash.put(num, position);
                }
            }
        }

        System.out.println(result);
    }
}
