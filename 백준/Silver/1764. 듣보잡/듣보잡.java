import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            hashSet.add(name);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (hashSet.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
