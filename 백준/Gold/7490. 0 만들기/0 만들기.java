import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<String> list = new ArrayList<>();

    static int calc(StringBuilder calc) {
        int sum = -1;

        StringBuilder sb = new StringBuilder();
        StringBuilder complete = new StringBuilder();
        String word = calc.toString().replace(" ", "");

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) - '0' > 0 && word.charAt(i) - '0' < 10) {
                sb.append(word.charAt(i));
            } else {
                complete.append(sb).append(" ").append(word.charAt(i)).append(" ");
                sb.setLength(0);
            }
        }

        complete.append(sb);
        String[] split = complete.toString().split(" ");

        if (split.length >= 3) {
            if (split[1].equals("+")) {
                sum = (Integer.parseInt(split[0]) + Integer.parseInt(split[2]));
            } else {
                sum = (Integer.parseInt(split[0]) - Integer.parseInt(split[2]));
            }

            for (int i = 3; i < split.length; i += 2) {
                if (split[i].equals("+")) {
                    sum += Integer.parseInt(split[i + 1]);
                } else {
                    sum -= Integer.parseInt(split[i + 1]);
                }
            }
        }

        return sum;
    }

    static void dfs(StringBuilder calc, int now, int goal) {
        if (now > goal) {
            if (calc(calc) == 0) {
                list.add(calc.toString());
            }

            return;
        }

        dfs(new StringBuilder(calc).append("+").append(now), now + 1, goal);
        dfs(new StringBuilder(calc).append("-").append(now), now + 1, goal);
        dfs(new StringBuilder(calc).append(" ").append(now), now + 1, goal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            dfs(new StringBuilder("1"), 2, n);

            Collections.sort(list);

            for (String s : list) {
                sb.append(s).append("\n");
            }
            sb.append("\n");

            list = new ArrayList<>();
        }

        System.out.println(sb);
    }
}
