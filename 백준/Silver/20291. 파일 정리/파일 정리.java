import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String word = st.nextToken();
            String extension = st.nextToken();

            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}
