import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static HashSet<Integer> knows;

    static int find(int a) {
        if (arr[a] == a) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (knows.contains(findB)) {
            int temp = findA;
            findA = findB;
            findB = temp;
        }

        arr[findB] = findA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        ArrayList<int[]> party = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());

        if (know == 0) {
            System.out.println(m);

            return;
        }

        knows = new HashSet<>();

        for (int i = 0; i < know; i++) {
            knows.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int people = Integer.parseInt(st.nextToken());
            int[] temp = new int[people];
            temp[0] = Integer.parseInt(st.nextToken());

            for (int j = 1; j < people; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
                union(temp[0], temp[j]);
            }

            party.add(temp);
        }

        int result = 0;

        for (int[] arr : party) {
            boolean flag = true;

            for (int i : arr) {
                if (knows.contains(find(i))) {
                    flag = false;

                    break;
                }
            }

            if (flag) {
                result += 1;
            }
        }

        System.out.println(result);
    }
}
