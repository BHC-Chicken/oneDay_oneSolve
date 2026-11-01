import java.util.*;

class Solution {
    int x;
    int y;
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    boolean[][] visited;
    int[][] score;
    
    boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < x && ny >= 0 && ny < y;
    }
    
    void bfs(int[][] maps) {
        Queue<Pair> queue = new ArrayDeque<>();
        visited[0][0] = true;
        score[0][0] = 1;
        
        queue.add(new Pair(0,0));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                
                if (inRange(nx, ny) && maps[nx][ny] != 0 && !visited[nx][ny]) {
                    queue.add(new Pair(nx, ny));
                    score[nx][ny] = score[pair.x][pair.y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        x = maps.length;
        y = maps[0].length;
        
        visited = new boolean[x][y];
        score = new int[x][y];
        
        bfs(maps);
        
        if (score[x - 1][y - 1] == 0) {
            return -1;
        }
        
        return score[x - 1][y - 1];
    }
}

class Pair {
    int x;
    int y;
    
    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}