import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int count;
    static boolean[] visit;
    static ArrayList<Integer>[] arr;

    static void dfs(int index) {
        if (visit[index]) {
            return;
        } else {
            visit[index] = true;
            for (int i : arr[index]) {
                if (!visit[i]) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        arr = new ArrayList[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}

