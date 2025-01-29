import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;

        boolean[] visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            if (!visited[cards[i] - 1]) {
                int count = 0;
                queue.add(cards[i] - 1);
                visited[cards[i] - 1] = true;

                while (!queue.isEmpty()) {
                    int now = queue.poll();

                    count++;

                    int next = cards[now] - 1;

                    if (visited[next]) {
                        continue;
                    }

                    queue.add(next);
                    visited[next] = true;
                }

                list.add(count);
            }
        }

        list.sort(Collections.reverseOrder());

        if (list.size() <= 1) {
            return 0;
        }
        
        return list.get(0) * list.get(1);
    }
}