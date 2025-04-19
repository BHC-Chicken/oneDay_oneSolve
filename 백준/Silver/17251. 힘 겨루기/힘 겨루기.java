import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] powers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            powers[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = powers[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], powers[i]);
        }

        rightMax[n - 1] = powers[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], powers[i]);
        }

        int redWin = 0, blueWin = 0;

        for (int i = 1; i < n; i++) {
            int red = leftMax[i - 1];
            int blue = rightMax[i];

            if (red > blue) redWin++;
            else if (red < blue) blueWin++;
        }

        if (redWin > blueWin) {
            System.out.println("R");
        } else if (blueWin > redWin) {
            System.out.println("B");
        } else {
            System.out.println("X");
        }
    }
}