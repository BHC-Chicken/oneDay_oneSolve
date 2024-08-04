import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int status;
    static int[][] map;

    static void reIndex(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.get(0).size(); i++) {
            int index = list.get(0).get(i);
            for (int j = 0; j < n; j++) {
                map[index][j] = status;
            }
        }

        for (int i = 0; i < list.get(1).size(); i++) {
            int index = list.get(1).get(i);
            for (int j = 0; j < n; j++) {
                map[j][index] = status;
            }
        }
    }

    static void reSum() {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == status) {
                    sum++;
                }
            }

            map[i][n] = sum;
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == status) {
                    sum++;
                }
            }

            map[n][i] = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        status = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        reSum();

        int prev = -1;
        int total = 0;
        int cal = n / 2 + 1;

        while (true) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());

            for (int i = 0; i < n; i++) {
                if (map[i][n] >= cal) {
                    list.get(0).add(i);
                }

                if (map[n][i] >= cal) {
                    list.get(1).add(i);
                }
            }

            total = list.get(0).size() + list.get(1).size();

            if (prev == total || total == (n * 2)) {

                break;
            } else {
                prev = total;
                reIndex(list);
                reSum();
                total = 0;
            }
        }

        if (total == (n * 2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}