import java.util.*;

class Solution {
    static boolean inRange(int x, int y) {
        return x >= 0 && x <= 10 && y >= 0 && y <= 10;
    }
    
    public int solution(String dirs) {
        int answer = 0;
        String[] input = dirs.split("");

        int nx = 5;
        int ny = 5;

        Pair[][] map = new Pair[11][11];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                map[i][j] = new Pair();
            }
        }

        for (int i = 0; i < dirs.length(); i++) {
            if (input[i].equals("U") && inRange(nx - 1, ny)) {
                if (map[nx - 1][ny].isVisit("U")) {
                    answer += 1;
                    map[nx][ny].list.add("D");
                }

                nx -= 1;
            } else if (input[i].equals("R") && inRange(nx, ny + 1)) {
                if (map[nx][ny + 1].isVisit("R")) {
                    answer += 1;
                    map[nx][ny].list.add("L");
                }

                ny += 1;
            } else if (input[i].equals("D") && inRange(nx + 1, ny)) {
                if (map[nx + 1][ny].isVisit("D")) {
                    answer += 1;
                    map[nx][ny].list.add("U");
                }

                nx += 1;
            } else if (input[i].equals("L") && inRange(nx, ny - 1)) {
                if (map[nx][ny - 1].isVisit("L")) {
                    answer += 1;
                    map[nx][ny].list.add("R");
                }

                ny -= 1;
            }
        }
        
        return answer;
    }
}

class Pair {
    ArrayList<String> list = new ArrayList<>();

    public boolean isVisit(String dir) {
        if (!list.contains(dir)) {
            list.add(dir);

            return true;
        }

        return false;
    }
}

