import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int l;
    static int[][] material;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            material = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                material[j][0] = Integer.parseInt(st.nextToken());
                material[j][1] = Integer.parseInt(st.nextToken());
            }

            hamburger(0,0,0);
            sb.append("#").append(i).append(" ").append(maxScore).append("\n");
            maxScore = 0;
        }

        System.out.println(sb);
    }

    static void hamburger(int index, int score, int cal) {
        if (cal > l) {
            return;
        }

        if (cal <= l) {
            maxScore = Math.max(maxScore, score);
        }

        if (index == n) {
            return;
        }

        hamburger(index + 1, score, cal);
        hamburger(index + 1, score + material[index][0], cal + material[index][1]);
    }
}
