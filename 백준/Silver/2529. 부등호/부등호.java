import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] arr;
    static int[] number = new int[10];
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    static void dfs(int count, int now, StringBuilder sb) {
        if (count == n) {
            max = Math.max(Long.parseLong(sb.toString()), max);
            min = Math.min(Long.parseLong(sb.toString()), min);

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (number[i] < 1) {
                if (arr[now].equals(">") && sb.charAt(sb.length() - 1) - '0' > i) {
                    sb.append(i);
                    number[i] = 1;
                    dfs(count + 1, now + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    number[i] = 0;
                } else if (arr[now].equals("<") && sb.charAt(sb.length() - 1) - '0' < i) {
                    number[i] = 1;
                    sb.append(i);
                    dfs(count + 1, now + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    number[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            number[i] = 1;
            dfs(0, 0, sb.append(i));
            number[i] = 0;
        }

        String maxForm = String.format("%0" + (n + 1) + "d", max);
        String minForm = String.format("%0" + (n + 1) + "d", min);

        System.out.println(maxForm);
        System.out.println(minForm);
    }
}