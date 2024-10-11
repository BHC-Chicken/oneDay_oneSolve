import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] zeroCount;
    static int[][] classMap;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static Pair searchMaxZero() {
        Pair zeroPair = null;
        int maxZero = -1;

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (zeroCount[j][k] > maxZero) {
                    maxZero = zeroCount[j][k];
                    zeroPair = new Pair(j, k);
                }
            }
        }

        return zeroPair;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        classMap = new int[n][n];
        zeroCount = new int[n][n];
        LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        HashMap<Integer, Pair> seat = new HashMap<>();

        int likeScore = 0;

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();

            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            map.put(num, list);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int zero = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (inRange(nx, ny)) {
                        zero++;
                    }
                }

                zeroCount[i][j] = zero;
            }
        }

        for (int i : map.keySet()) {
            ArrayList<Integer> list = map.get(i);

            Pair likePair = null;
            int maxLike = -1;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int likeCount = 0;

                    if (classMap[j][k] == 0) {
                        for (int l = 0; l < 4; l++) {
                            int nx = j + dx[l];
                            int ny = k + dy[l];

                            if (inRange(nx, ny) && list.contains(classMap[nx][ny])) {
                                likeCount++;
                            }
                        }

                        if (maxLike == likeCount) {

                            if (zeroCount[likePair.x][likePair.y] < zeroCount[j][k]) {
                                likePair = new Pair(j,k);
                            }
                        } else if (maxLike < likeCount) {
                            maxLike = likeCount;
                            likePair = new Pair(j, k);
                        }
                    }
                }
            }

            if (likePair != null) {
                classMap[likePair.x][likePair.y] = i;
                zeroCount[likePair.x][likePair.y] = 0;

                for (int j = 0; j < 4; j++) {
                    int nx = likePair.x + dx[j];
                    int ny = likePair.y + dy[j];

                    if (inRange(nx,ny) && zeroCount[nx][ny] > 0) {
                        zeroCount[nx][ny] -= 1;
                    }
                }

                seat.put(i, new Pair(likePair.x, likePair.y));
            } else {
                Pair zeroPair = searchMaxZero();

                classMap[zeroPair.x][zeroPair.y] = i;

                for (int j = 0; j < 4; j++) {
                    int nx = zeroPair.x + dx[j];
                    int ny = zeroPair.y + dy[j];

                    if (inRange(nx,ny) && zeroCount[nx][ny] > 0) {
                        zeroCount[nx][ny] -= 1;
                    }
                }

                seat.put(i, new Pair(zeroPair.x, zeroPair.y));
            }
        }

        for(int i : map.keySet()) {
            ArrayList<Integer> list = map.get(i);
            Pair seatPair = seat.get(i);
            int likeCount = 0;

            for (int j = 0; j < 4; j++) {
                int nx = seatPair.x + dx[j];
                int ny = seatPair.y + dy[j];

                if (inRange(nx, ny) && list.contains(classMap[nx][ny])) {
                    likeCount++;
                }
            }

            if (likeCount == 1) {
                likeScore += 1;
            } else if (likeCount == 2) {
                likeScore += 10;
            } else if (likeCount == 3) {
                likeScore += 100;
            } else if (likeCount == 4) {
                likeScore += 1000;
            }
        }

        System.out.println(likeScore);
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
