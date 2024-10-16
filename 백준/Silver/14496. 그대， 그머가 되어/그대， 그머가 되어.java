import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int a = 0;
    static int b = 0;
    static int N = 0;
    static int M = 0;
    static int ans = Integer.MAX_VALUE;

    static boolean[] visit;
    static ArrayList<Integer>[] list;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        pq.add(new int[]{a, 0});
        visit[a] = true;

        while (!pq.isEmpty()) {
            int[] n = pq.poll();

            if (n[0] == b) {
                ans = Math.min(ans, n[1]);
                continue;
            }

            for (int i = 0; i < list[n[0]].size(); i++) {
                int next = list[n[0]].get(i);
                if (!visit[next]) {
                    pq.add(new int[]{next, n[1] + 1});
                    visit[next] = true;
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
