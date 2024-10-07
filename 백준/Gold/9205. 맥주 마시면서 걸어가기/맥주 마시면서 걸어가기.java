import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int convenience;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static ArrayList<Pair> list;
    static boolean flag;
    static boolean[] visited;

    static void dfs(Pair pair) {
        int cal = Math.abs((pair.x - endX)) + Math.abs((pair.y - endY));

        if (cal <= 1000) {
            flag = true;

            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Pair pair1 = list.get(i);
            cal = Math.abs((pair1.x - pair.x)) + Math.abs((pair1.y - pair.y));

            if (cal <= 1000 && !visited[i]) {
                visited[i] = true;
                dfs(pair1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            convenience = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            visited = new boolean[convenience + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            for (int j = 0; j < convenience; j++) {
                st = new StringTokenizer(br.readLine());

                list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            dfs(new Pair(startX, startY));

            if (!flag) {
                sb.append("sad");
            } else {
                sb.append("happy");
            }
            sb.append("\n");

            flag = false;
        }

        System.out.println(sb);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
