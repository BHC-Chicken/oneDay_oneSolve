import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[] map;
    static int count = 0;

    static void dfs(int depth) {
        if (depth == n) {
            count++;

            return;
        }

        for (int i = 0; i < n; i++) {
            map[depth] = i;

            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (map[depth] == map[i]) {
                return false;
            }

            if (Math.abs(i - depth) == Math.abs(map[i] - map[depth])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n];
            count = 0;

            dfs(0);

            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}
