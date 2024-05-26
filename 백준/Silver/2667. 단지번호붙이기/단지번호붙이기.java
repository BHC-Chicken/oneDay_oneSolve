import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Pair> queue;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int count = 0;

        arr = new int[n][n];
        visited = new boolean[n][n];
        queue = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int apt = 0;
                if (!visited[i][j]) {
                    visited[i][j] = true;

                    if (arr[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        apt++;

                        int cx = 0;
                        int cy = 0;

                        while (!queue.isEmpty()) {
                            Pair pair = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                cx = pair.x + dx[k];
                                cy = pair.y + dy[k];

                                if (inRange(cx, cy) && !visited[cx][cy]) {
                                    visited[cx][cy] = true;
                                    if (arr[cx][cy] == 1) {
                                        queue.add(new Pair(cx, cy));
                                        apt++;
                                    }
                                }
                            }
                        }
                        count++;
                    }
                }
                if (apt != 0) {
                    list.add(apt);
                }
            }
        }

        Collections.sort(list);

        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}