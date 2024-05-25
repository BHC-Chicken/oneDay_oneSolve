import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] seq = new int[n + 1];
            int[] arr = new int[n + 1];
            boolean[] visit = new boolean[n + 1];

            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());

                seq[j] = num;
                arr[j] = num;
            }

            Arrays.sort(seq);

            visit[1] = true;
            int start = arr[1];
            boolean loop = true;

            while (loop) {
                if(!visit[seq[start]]) {
                    visit[seq[start]] = true;
                    start = arr[start];
                } else {
                    count++;

                    for (int j = 1; j <= n ; j++) {
                        if (!visit[j]) {
                            start = arr[j];

                            break;
                        }

                        if (j == n) {
                            loop = false;
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}