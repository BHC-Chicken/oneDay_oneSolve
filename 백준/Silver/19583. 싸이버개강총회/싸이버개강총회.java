import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        HashMap<String, String> userMap = new HashMap<>();

        String streamingStart = "0000";
        String start = st.nextToken().replace(":", "");
        String end = st.nextToken().replace(":", "");
        String streamingEnd = st.nextToken().replace(":", "");

        String word;

        while ((word = br.readLine()) != null) {
            StringTokenizer user = new StringTokenizer(word);

            String time = user.nextToken().replace(":", "");
            String name = user.nextToken();

            if (userMap.containsKey(name)) {
                if (time.compareTo(end) >= 0 && time.compareTo(streamingEnd) <= 0) {
                    userMap.remove(name);
                    result++;
                }
            } else {
                if (time.compareTo(streamingStart) >= 0 && time.compareTo(start) <= 0) {
                    userMap.put(name, time);
                }
            }
        }

        System.out.println(result);
    }
}
