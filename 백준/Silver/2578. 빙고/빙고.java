import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo = new int[5][5];
    static boolean[] rowBool = new boolean[5];
    static boolean[] colBool = new boolean[5];
    static boolean leftUpBool = false;
    static boolean rightUpBool = false;

    static int result;
    static int bingoCount;

    static boolean rowCheck() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (rowBool[i]) {
                continue;
            }
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) {
                    count++;

                    if (count == 5) {
                        result++;
                        rowBool[i] = true;
                    }
                }
            }
            count = 0;
        }

        return bingoCheck();
    }

    static boolean colCheck() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (colBool[i]) {
                continue;
            }
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) {
                    count++;

                    if (count == 5) {
                        result++;
                        colBool[i] = true;
                    }
                }
            }
            count = 0;
        }

        return bingoCheck();
    }

    static boolean leftUpCrossCheck() {
        if (leftUpBool) {
            return false;
        }
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                count++;

                if (count == 5) {
                    result++;
                    leftUpBool = true;
                }
            }
        }

        return bingoCheck();
    }

    static boolean rightUpCrossCheck() {
        if (rightUpBool) {
            return false;
        }
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) {
                count++;

                if (count == 5) {
                    result++;
                    rightUpBool = true;
                }
            }
        }

        return bingoCheck();
    }

    static boolean bingoCheck() {
        if (result >= 3) {
            System.out.println(bingoCount);

            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 5; k++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int target = Integer.parseInt(st.nextToken());

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (bingo[i][j] == target) {
                            bingo[i][j] = 0;
                            bingoCount++;
                        }
                    }
                }

                if (rowCheck()) {
                    return;
                } else if (colCheck()) {
                    return;
                } else if (leftUpCrossCheck()) {
                    return;
                } else if (rightUpCrossCheck()) {
                    return;
                }
            }
        }
    }
}
