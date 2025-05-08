import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Pair> getPosition(char[][] map, int n, int m) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'O') {
                    list.add(new Pair(i, j));
                }
            }
        }

        return list;
    }

    static int moveCount(ArrayList<Pair> source, ArrayList<Pair> target) {
        int min = Integer.MAX_VALUE;
        int maxShift = 10;

        for (int i = -maxShift; i <= maxShift; i++) {
            for (int j = -maxShift; j <= maxShift; j++) {
                HashSet<String> set = new HashSet<>();

                for (Pair pair : target) {
                    int x = pair.x + i;
                    int y = pair.y + j;

                    set.add(x + "," + y);
                }

                int miss = 0;

                for (Pair pair : source) {
                    String value = pair.x + "," + pair.y;

                    if (!set.contains(value)) {
                        miss++;
                    }
                }

                min = Math.min(min, miss);
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        char[][] map1 = new char[n1][m1];

        for (int i = 0; i < n1; i++) {
            map1[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());

        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        char[][] map2 = new char[n2][m2];

        for (int i = 0; i < n2; i++) {
            map2[i] = br.readLine().toCharArray();
        }

        ArrayList<Pair> source = getPosition(map1, n1, m1);
        ArrayList<Pair> target = getPosition(map2, n2, m2);

        int result = moveCount(source, target);

        System.out.println(result);
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
