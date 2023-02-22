import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        for (int i = 0; i < loop; i++) {
            String word = br.readLine();
            if (word.length() < length) {
                continue;
            }
            if (map.containsKey(word)) {
                int value = map.get(word);
                map.put(word, value + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort(((o1, o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            if (c1==c2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return c2-c1;
        }));

        for (String s : words) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
