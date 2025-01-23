import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static int x;
    static int y;

    static boolean inRange(int dx, int dy) {
        return dx >= 0 && dx < x && dy >= 0 && dy < y;
    }
    
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;

        x = board.length;
        y = board[0].length();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        String[][] map = new String[x][y];
        boolean[][] visited = new boolean[x][y];
        Pair start = null;

        for (int i = 0; i < map.length; i++) {
            String[] road = board[i].split("");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = road[j];
                if (road[j].equals("R")) {
                    start = new Pair(i, j, 0);
                    visited[i][j] = true;
                }
            }
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (!inRange(nx, ny) || map[nx][ny].equals("D")) {
                    continue;
                }

                while (inRange(nx + dx[i], ny + dy[i]) && !map[nx + dx[i]][ny + dy[i]].equals("D")) {
                    nx += dx[i];
                    ny += dy[i];
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny].equals("G")) {
                    answer = Math.min(answer, pair.count + 1);
                } else {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny, pair.count + 1));
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }
}

class Pair {
    int x;
    int y;
    int count;

    public Pair(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}