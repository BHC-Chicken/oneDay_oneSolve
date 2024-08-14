import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        int plate = Integer.parseInt(st.nextToken());
        int kindOfSushi = Integer.parseInt(st.nextToken());
        int conti = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] plates = new int[plate];
        int[] visited = new int[kindOfSushi + 1];

        for (int i = 0; i < plate; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < conti; i++) {
            if (visited[plates[i]] == 0) {
                count++;
            }

            visited[plates[i]]++;
        }

        for (int i = 0; i < plate; i++) {
            if (visited[coupon] == 0) {
                max = Math.max(max, count + 1);
            } else {
                max = Math.max(max, count);
            }

            visited[plates[i]]--;
            if (visited[plates[i]] == 0) {
                count--;
            }

            int end = (i + conti) % plate;
            if (visited[plates[end]] == 0) {
                count++;
            }

            visited[plates[end]]++;
        }

        System.out.println(max);
    }
}

