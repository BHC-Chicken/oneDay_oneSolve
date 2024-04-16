import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] mine;

    static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    static boolean left(int row, int col) {
        return inRange(row, col - 1) && mine[row][col - 1] == 1;
    }

    static boolean right(int row, int col) {
        return inRange(row, col + 1) && mine[row][col + 1] == 1;
    }

    static boolean up(int row, int col) {
        return inRange(row - 1, col) && mine[row - 1][col] == 1;
    }

    static boolean down(int row, int col) {
        return inRange(row + 1, col) && mine[row + 1][col] == 1;
    }

    static boolean leftUp(int row, int col) {
        return inRange(row - 1, col - 1) && mine[row - 1][col - 1] == 1;
    }

    static boolean leftDown(int row, int col) {
        return inRange(row + 1, col - 1) && mine[row + 1][col - 1] == 1;
    }

    static boolean rightUp(int row, int col) {
        return inRange(row - 1, col + 1) && mine[row - 1][col + 1] == 1;
    }

    static boolean rightDown(int row, int col) {
        return inRange(row + 1, col + 1) && mine[row + 1][col + 1] == 1;
    }

    static int searchMine(int row, int col) {
        int count = 0;

        if (left(row, col)) {
            count++;
        }
        if (right(row, col)) {
            count++;
        }
        if (up(row, col)) {
            count++;
        }
        if (down(row, col)) {
            count++;
        }
        if (leftUp(row, col)) {
            count++;
        }
        if (leftDown(row, col)) {
            count++;
        }
        if (rightUp(row, col)) {
            count++;
        }
        if (rightDown(row, col)) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder success = new StringBuilder();
        StringBuilder fail = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        mine = new int[n][n];

        boolean stepMine = false;

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (temp[j].equals(".")) {
                    mine[i][j] = 0;
                } else {
                    mine[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (temp[j].equals("x")) {
                    int count = searchMine(i, j);

                    if (mine[i][j] == 1) {
                        stepMine = true;
                        fail.append("*");
                    } else {
                        fail.append(count);
                    }

                    success.append(count);
                } else {
                    if (mine[i][j] == 1) {
                        fail.append("*");
                    } else {
                        fail.append(".");
                    }

                    success.append(".");
                }
            }
            success.append("\n");
            fail.append("\n");
        }

        if (stepMine) {
            System.out.println(fail);
        } else {
            System.out.println(success);
        }
    }
}
