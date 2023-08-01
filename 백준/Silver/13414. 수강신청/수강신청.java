import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int max = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < people; i++) {
            String num = br.readLine();

            if (set.contains(num)) {
                set.remove(num);
                set.add(num);
            } else {
                set.add(num);
            }
        }

        int index = 0;

        for (String num : set) {
            sb.append(num).append("\n");
            index++;

            if (max == index) {
                break;
            }
        }

        System.out.println(sb);
    }
}
