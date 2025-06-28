import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] pay;
    static List<Pair>[] discount;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void dfs(int index, int coin) {
        if (coin >= min) {
            return;
        }

        if (index == n + 1) {
            min = coin;

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            for (Pair p : discount[i]) {
                pay[p.index] -= p.amount;
            }

            dfs(index + 1, coin + (pay[i] <= 0 ? 1 : pay[i]));

            for (Pair p : discount[i]) {
                pay[p.index] += p.amount;
            }

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pay = new int[n + 1];
        visited = new boolean[n + 1];
        discount = new List[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
            discount[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());

                discount[i].add(new Pair(index, amount));
            }
        }

        dfs(1,0);

        System.out.println(min);
    }
}

class Pair {
    int index;
    int amount;

    public Pair(int index, int amount) {
        this.index = index;
        this.amount = amount;
    }
}
