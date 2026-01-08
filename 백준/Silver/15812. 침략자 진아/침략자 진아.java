import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Pair> houseList = new ArrayList<>();
        List<Pair> spaceList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(line[j]) == 1) {
                    houseList.add(new Pair(i, j));
                } else {
                    spaceList.add(new Pair(i, j));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < spaceList.size(); i++) {
            for (int j = i + 1; j < spaceList.size(); j++) {
                Pair p1 = spaceList.get(i);
                Pair p2 = spaceList.get(j);

                int dist = 0;

                for (Pair house : houseList) {
                    int dist1 = Math.abs(p1.x - house.x) + Math.abs(p1.y - house.y);
                    int dist2 = Math.abs(p2.x - house.x) + Math.abs(p2.y - house.y);

                    int goalTime = Math.min(dist1, dist2);

                    dist = Math.max(dist, goalTime);

                    if (dist >= min) {
                        break;
                    }
                }

                min = Math.min(min, dist);
            }
        }

        System.out.println(min);
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
