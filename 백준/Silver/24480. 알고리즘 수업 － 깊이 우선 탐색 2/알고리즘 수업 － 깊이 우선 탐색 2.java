import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] arr;
    static int count;

    static void dfs(int r) {
        arr[r] = count;

        for (int i = 0; i < list.get(r).size(); i++) {
            int node = list.get(r).get(i);
            if (arr[node] == 0) {
                count++;
                dfs(node);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        arr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        for (int i = 1; i <= n ; i++) {
            list.get(i).sort(Collections.reverseOrder());
        }

        count = 1;
        dfs(r);

        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
