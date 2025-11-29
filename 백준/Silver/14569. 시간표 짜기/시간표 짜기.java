import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Set<Integer>> subjectList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Set<Integer> time = new HashSet<>();

            for (int j = 0; j < k; j++) {
                time.add(Integer.parseInt(st.nextToken()));
            }
            subjectList.add(time);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            Set<Integer> empty = new HashSet<>();

            for (int j = 0; j < p; j++) {
                empty.add(Integer.parseInt(st.nextToken()));
            }

            int count = 0;

            for (Set<Integer> subject : subjectList) {
                if (empty.containsAll(subject)) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
