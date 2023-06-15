import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int total = 0;

        String word = br.readLine();

        do {
            map.put(word, map.getOrDefault(word, 0) + 1);
            total++;
            word = br.readLine();

        } while (word != null && word.length() != 0);

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            double result = ((double) map.get(s) / total) * 100;
            result = Math.round(result * 10000) / 10000.0;
            sb.append(s).append(" ").append(String.format("%.4f", result)).append("\n");
        }

        System.out.println(sb);
    }
}