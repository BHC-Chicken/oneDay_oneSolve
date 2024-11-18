import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        boolean[] isBroken = new boolean[n + 1];

        for (int i = 0; i < b; i++) {
            isBroken[Integer.parseInt(br.readLine())] = true;
        }

        int brokenCount = 0;
        for (int i = 1; i <= k; i++) {
            if (isBroken[i]) {
                brokenCount += 1;
            }
        }

        int result = brokenCount;

        for (int i = k + 1; i <= n; i++) {
            if (isBroken[i]) {
                brokenCount += 1;
            }
            
            if (isBroken[i -k]) {
                brokenCount -= 1;
            }
            
            result = Math.min(result, brokenCount);
        }

        System.out.println(result);
    }
}
