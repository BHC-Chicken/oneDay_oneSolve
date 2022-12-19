import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            switch (cal) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    if (set.contains(num)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    set.clear();
                    for (int b = 1; b <= 20; b++) {
                        set.add(b);
                    }
                    break;
                case "empty":
                    set.clear();
            }

        }
        System.out.println(sb);
    }
}