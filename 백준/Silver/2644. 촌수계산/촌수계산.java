import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int human1;
    static int human2;
    static int people;
    static int relation;
    static boolean result;

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    static void dfs(int depth, int human) {
        if (human == human2) {
            System.out.println(depth);
            result = true;

            return;
        }

        ArrayList<Integer> humanList = list.get(human);
        visited[human] = true;

        for (int i : humanList) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        human1 = Integer.parseInt(st.nextToken());
        human2 = Integer.parseInt(st.nextToken());

        relation = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[people + 1];

        for (int i = 0; i <= people; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        dfs(0, human1);

        if (!result) {
            System.out.println(-1);
        }
    }
}
