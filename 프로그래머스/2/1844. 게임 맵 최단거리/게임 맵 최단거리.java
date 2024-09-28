import java.util.*;

class Solution {
    int x;
    int y;
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int[][] score;
    boolean[][] visited;
    
    boolean inRange(int dx, int dy) {
        return dx >= 0 && dx < x && dy >= 0 && dy < y;
    }
    
    void bfs(int[][] maps) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        visited[0][0] = true;
        score[0][0] = 1;
        
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                
                if(inRange(nx, ny) && !visited[nx][ny] && maps[nx][ny] != 0) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    score[nx][ny] = score[pair.x][pair.y] + 1;
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        x = maps.length;
        y = maps[0].length;
        
        score = new int[x][y];
        visited = new boolean[x][y];
        
        bfs(maps);
        
        if(score[x - 1][y - 1] == 0) {
            return -1;
        }
        
        return score[x - 1][y - 1];
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