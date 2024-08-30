import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int totalDepth = 0;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    static void dfs(int index, int parent, int depth) {
        if (parent != -1 && tree.get(index).size() == 1) {
            totalDepth += depth;

            return;
        }

        for (int next : tree.get(index)) {
            if (next != parent) {
                dfs(next, index, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i <= loop; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < loop - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1, -1, 0);

        if (totalDepth % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}