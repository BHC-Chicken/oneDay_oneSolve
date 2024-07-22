import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr = new int[1000001];
    static int[] cost = new int[1000001];

    static int find(int a) {
        if (arr[a] == a) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            arr[findA] = findB;
            cost[findB] += cost[findA];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 1000000; i++) {
            arr[i] = i;
            cost[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = 0;
            if (st.hasMoreTokens()) {
                b = Integer.parseInt(st.nextToken());
            }

            if (cmd.equals("I")) {
                union(a, b);
            } else if (cmd.equals("Q")) {
                sb.append(cost[find(a)]).append("\n");
            }
        }

        System.out.println(sb);
    }
}

