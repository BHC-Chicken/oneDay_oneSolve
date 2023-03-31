import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {
            if (!rankMap.containsKey(v)) {
                rankMap.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranking = rankMap.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}
