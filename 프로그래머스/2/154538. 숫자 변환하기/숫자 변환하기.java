import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[3000001];

        queue.add(new Pair(x, 0));
        visited[x] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.now == y) {
                return p.count;
            }

            if (!visited[p.now + n] && p.now + n <= y) {
                queue.add(new Pair(p.now + n, p.count + 1));
                visited[p.now + n] = true;
            }

            if (!visited[p.now * 2] && p.now * 2 <= y) {
                queue.add(new Pair(p.now * 2, p.count + 1));
                visited[p.now * 2] = true;
            }

            if (!visited[p.now * 3] && p.now * 3 <= y) {
                queue.add(new Pair(p.now * 3, p.count + 1));
                visited[p.now * 3] = true;
            }
        }

        return -1;
    }
}

class Pair {
    int now;
    int count;

    public Pair(int now, int count) {
        this.now = now;
        this.count = count;
    }
}
