import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Pair[] egg;
    static int result;

    static void dfs(int index, int count) {
        result = Math.max(result, count);

        if (index == n) {

            return;
        }

        if (egg[index].s <= 0) {
            dfs(index + 1, count);
        } else {
            for (int i = 0; i < n; i++) {
                if (i == index || egg[i].s <= 0) {
                    continue;
                }


                egg[index].s -= egg[i].w;
                egg[i].s -= egg[index].w;

                int newEgg = count;

                if (egg[index].s <= 0) {
                    newEgg++;
                }
                if (egg[i].s <= 0) {
                    newEgg++;
                }

                dfs(index + 1, newEgg);

                egg[index].s += egg[i].w;
                egg[i].s += egg[index].w;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        egg = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            egg[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        System.out.println(result);
    }
}

class Pair {
    int s;
    int w;

    public Pair(int s, int w) {
        this.s = s;
        this.w = w;
    }
}
