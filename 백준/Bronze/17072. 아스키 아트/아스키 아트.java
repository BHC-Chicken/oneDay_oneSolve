import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int calc(int[] color) {
        int r = color[0] * 2126;
        int g = color[1] * 7152;
        int b = color[2] * 722;

        return r + g + b;
    }

    static String choice(int total) {
        if (total >= 0 && total < 510_000) {
            return "#";
        }

        if (total >= 510_000 && total < 1_020_000) {
            return "o";
        }

        if (total >= 1_020_000 && total < 1_530_000) {
            return "+";
        }

        if (total >= 1_530_000 && total < 2_040_000) {
            return "-";
        }

        return ".";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split(" ");
            for (int j = 0; j < m * 3; j += 3) {
                int index = 0;
                int[] color = new int[3];
                for (int k = j; k < j + 3; k++) {
                    color[index] = Integer.parseInt(word[k]);
                    index++;
                }
                sb.append(choice(calc(color)));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}