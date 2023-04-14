import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        ArrayList<String> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if (s.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
