import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, String> dogam = new HashMap<>();
        HashMap<String, Integer> dogam2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(st.nextToken());
        int correct = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= loop; i++) {
            String poketmon = br.readLine();
            dogam.put(i, poketmon);
            dogam2.put(poketmon, i);
        }

        for (int i = 0; i < correct; i++) {
            String s = br.readLine();
            try {
                int num = Integer.parseInt(s);
                sb.append(dogam.get(num)).append("\n");
            } catch (Exception e) {
                sb.append(dogam2.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }
}