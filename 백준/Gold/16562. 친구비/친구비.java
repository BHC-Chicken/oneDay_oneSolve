import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] cost;
    static boolean[] visited;

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
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        cost = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            int prevCost = cost[i];
            int prevFind = find(arr[i]);

            visited[i] = true;
            result += prevCost;

            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (find(arr[j]) == prevFind) {
                    visited[j] = true;
                    if (prevCost > cost[j]) {
                        result -= prevCost;
                        result += cost[j];
                        prevCost = cost[j];
                    }
                }
            }
        }

        if (result > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(result);
        }
    }
}

