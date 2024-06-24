import java.io.*;
import java.util.*;

public class Main {

    static int row;
    static int col;
    static int N;

    static char[][] curMap;
    static char[][] nMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder res = new StringBuilder();

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        curMap = new char[row][col];
        nMap = new char[row][col];

        /* map init */
        for(int i = 0; i < row; i++) {
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < col; j++) {
                curMap[i][j] = c[j];
            }
        }

        if (N == 1) {
            // Initial state remains unchanged
            printMap(curMap);
        } else if (N % 2 == 0) {
            // All cells are filled with bombs
            fillMapWithBombs();
            printMap(nMap);
        } else {
            // Odd N, we need to simulate 3 seconds or 5 seconds
            simulate(3);
            if (N % 4 == 3) {
                printMap(nMap);
            } else {
                // Simulate further to 5 seconds state (next 3-second state after initial)
                char[][] tempMap = copyMap(nMap);
                curMap = tempMap;
                simulate(3);
                printMap(nMap);
            }
        }
    }

    static void simulate(int seconds) {
        for (int i = 0; i < seconds; i++) {
            fillMapWithBombs();
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (curMap[r][c] == 'O') {
                        nMap[r][c] = '.';
                        if (r - 1 >= 0) nMap[r - 1][c] = '.';
                        if (r + 1 < row) nMap[r + 1][c] = '.';
                        if (c - 1 >= 0) nMap[r][c - 1] = '.';
                        if (c + 1 < col) nMap[r][c + 1] = '.';
                    }
                }
            }
            curMap = copyMap(nMap);
        }
    }

    static void fillMapWithBombs() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nMap[i][j] = 'O';
            }
        }
    }

    static char[][] copyMap(char[][] map) {
        char[][] newMap = new char[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, col);
        }
        return newMap;
    }

    static void printMap(char[][] map) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res.append(map[i][j]);
            }
            res.append('\n');
        }
        System.out.print(res);
    }
}