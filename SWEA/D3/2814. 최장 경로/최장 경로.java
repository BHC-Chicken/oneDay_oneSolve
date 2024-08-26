import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int maxPath;

    public static void dfs(int node, int pathLength) {
        maxPath = Math.max(maxPath, pathLength);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor, pathLength + 1);
                visited[neighbor] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            maxPath = 0;

            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }

            sb.append("#").append(test_case).append(" ").append(maxPath).append("\n");
        }

        System.out.println(sb);
    }
}