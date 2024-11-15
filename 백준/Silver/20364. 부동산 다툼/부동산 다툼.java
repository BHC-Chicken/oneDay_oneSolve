import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        int[] tree = new int[n + 1];
        tree[1] = Integer.MAX_VALUE;

        for (int i = 0; i < q; i++) {
            int result = Integer.MAX_VALUE;
            int quack = Integer.parseInt(br.readLine());
            int temp = quack;

            while (1 != temp) {
                if (tree[temp] != 0) {
                    result = Math.min(result, temp);
                }

                if (temp % 2 == 0) {
                    temp /= 2;
                } else {
                    temp = (temp - 1) / 2;
                }
            }

            if (result == Integer.MAX_VALUE) {
                sb.append("0").append("\n");
                tree[quack]++;
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }
}
