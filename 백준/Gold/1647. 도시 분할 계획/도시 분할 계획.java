import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static Tuple[] tuples;
    static int[] arr;

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
            arr[findB] = findA;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tuples = new Tuple[m];
        arr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tuples[i] = new Tuple(a, b, c);
        }

        Arrays.sort(tuples);

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        int result = 0;
        int maxC = 0;
        for (int i = 0; i < m; i++) {
            Tuple tuple = tuples[i];

            if (find(tuple.a) != find(tuple.b)) {
                result += tuple.c;
                maxC = tuple.c;
                union(tuple.a, tuple.b);
            }
        }

        System.out.println(result - maxC);
    }
}

class Tuple implements Comparable<Tuple> {
    int a;
    int b;
    int c;

    public Tuple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Tuple o) {
        return Integer.compare(this.c, o.c);
    }
}