import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static char[][] map;
    static boolean[][] bomb;

    static void searchChar(int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = map[i][j];

                if (c != '.' && c == map[i][j + 1] && c == map[i + 1][j] && c == map[i + 1][j + 1]) {
                    bomb[i][j] = true;
                }
            }
        }
    }

    static int bombChar() {
        int sum = 0;

        for (int i = 0; i < bomb.length - 1; i++) {
            for (int j = 0; j < bomb[i].length - 1; j++) {
                if (bomb[i][j]) {
                    if (map[i][j] == '.') {
                        sum--;
                    } else {
                        map[i][j] = '.';
                    }

                    if (map[i][j + 1] == '.') {
                        sum--;
                    } else {
                        map[i][j + 1] = '.';
                    }

                    if (map[i + 1][j] == '.') {
                        sum--;
                    } else {
                        map[i + 1][j] = '.';
                    }

                    if (map[i+1][j+1] == '.') {
                        sum--;
                    } else {
                        map[i + 1][j + 1] = '.';
                    }

                    sum += 4;
                }
            }
        }

        return sum;
    }

    static void sorting() {
        for (int i = 0; i < map[0].length; i++) {
            int firstZero = 31;
            Queue<Integer> queue = new LinkedList<>();

            for (int j = map.length - 1; j >= 0; j--) {
                if (firstZero == 31 && map[j][i] == '.') {
                    firstZero = j;
                }

                if (firstZero != 31 && map[j][i] != '.') {
                    queue.add(j);
                }
            }

            while (!queue.isEmpty()) {
                int row = queue.poll();

                map[firstZero--][i] = map[row][i];
                map[row][i] = '.';
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int sum = -1;
        int answer = 0;

        while (sum != 0) {
            bomb = new boolean[m][n];
            searchChar(m, n);
            sum = bombChar();

            if (sum == -1) {
                break;
            }
            sorting();

            answer += sum;
        }
        
        return answer;
    }
}